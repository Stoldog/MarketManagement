package com.stoldog.daoImp;

import com.stoldog.entity.Pages;
import com.stoldog.entity.Repertory;
import com.stoldog.entity.RepertoryList;
import com.stoldog.entity.RepertorySerial;
import com.stoldog.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by RL on 2017/4/18.
 */
@Repository
public class RepertoryDaoImp extends CommonDaoImp{
    //生成再返回批次序列号
    public RepertorySerial getRepertorySerial(Integer uid, String userName, Long enterTime){
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into repertory_serial (enterUserId,enterUserName,enterTime) values(?,?,?)";
        String sql2="select * from repertory_serial where enterUserId=? and enterUserName=? and enterTime=?";
        //String sql3="SELECT LAST_INSERT_ID() FROM repertory_serial LIMIT 1";
        Object [] params={uid,userName,enterTime};
        try {
            queryRunner.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RepertorySerial repertorySerial= null;
        try {
            repertorySerial = queryRunner.query(sql2,new BeanHandler<RepertorySerial>(RepertorySerial.class),uid,userName,enterTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repertorySerial;
    }
    //批量进货录入
    public int[] entringRepertory(RepertorySerial repertorySerial,List<Repertory> repertoryList) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into repertory (productId,productTime,effectTime,productSerialNo,enterSerialNo,productNum) values (?,?,?,?,?,?)";
        int listlength=repertoryList.size();
        Object[][] params=new Object[listlength][];
        for (int i=0;i<listlength;i++){
            params[i]=new Object[6];
            params[i][0]=repertoryList.get(i).getProductId();
            params[i][1]=repertoryList.get(i).getProductTime();
            params[i][2]=repertoryList.get(i).getEffectTime();
            params[i][3]=repertoryList.get(i).getProductSerialNo();
            params[i][4]=repertorySerial.getEnterSerialNo();
            params[i][5]=repertoryList.get(i).getProductNum();
        }
        return queryRunner.batch(sql,params);
    }
    //查询所有货物
    public List<RepertoryList> getAllRepertory() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT  repertory.productId,product_info.productName,repertory.productSerialNo,repertory.enterSerialNo,product_info.marketPrice,product_info.productType,product_info.effectTime,repertory.productTime,repertory.productNum FROM repertory,product_info WHERE repertory.productId=product_info.pid;";
        return queryRunner.query(sql,new BeanListHandler<RepertoryList>(RepertoryList.class));
    }
    //获得货物的键值
    public List getRepertoryKeyValue() throws SQLException{
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT repertory.productSerialNo,product_info.productName FROM repertory,product_info WHERE repertory.productId=product_info.pid";
        return queryRunner.query(sql,new MapListHandler());
    }
    //通过序列号查询货物
    public List getRepertoryByProductSerial(Integer productSerialNo) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT  repertory.productId,product_info.productName,repertory.productSerialNo,repertory.enterSerialNo,product_info.marketPrice,product_info.productType,product_info.effectTime,repertory.productTime,repertory.productNum,product_info.productUnit FROM repertory,product_info WHERE repertory.productId=product_info.pid and repertory.productSerialNo=?;";
        return queryRunner.query(sql,new MapListHandler(),productSerialNo);

    }
    //查询某批次货物
    public List<RepertoryList> getRepertoryByEnterSerialNo(Repertory repertory,Pages pages) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT  repertory.productId,product_info.productName,repertory.productSerialNo,repertory.enterSerialNo,product_info.marketPrice,product_info.productType,product_info.effectTime,repertory.productTime,repertory.productNum FROM repertory,product_info WHERE repertory.productId=product_info.pid and repertory.enterSerialNo=?  LIMIT ?,?;";
        return queryRunner.query(sql,new BeanListHandler<RepertoryList>(RepertoryList.class),repertory.getEnterSerialNo(),pages.calCurPage(),pages.getPageSize());
    }
    //查询数量不足的所有货物(低于某个数量的所有货物)
    public List<RepertoryList> getRepertoryLessThanProductNum(Repertory repertory,Pages pages) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT  repertory.productId,product_info.productName,repertory.productSerialNo,repertory.enterSerialNo,product_info.marketPrice,product_info.productType,product_info.effectTime,repertory.productTime,repertory.productNum FROM repertory,product_info WHERE repertory.productId=product_info.pid AND repertory.productNum<=? LIMIT ?,?;";
        return queryRunner.query(sql,new BeanListHandler<RepertoryList>(RepertoryList.class),repertory.getProductNum(),pages.calCurPage(),pages.getPageSize());
    }
    //卖出某个数数量的某种货物
    public int[] reduceRepertoryNum(List<Repertory> repertoryList,Integer nums) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="UPDATE repertory SET productNum=productNum-? WHERE productSerialNo=? AND productId=?";
        return queryRunner.batch(sql,repertory.getProductId(),repertory.getProductSerialNo());
    }
    //查询货物列表
    public List<RepertoryList> getRepertoryList(Pages pages) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT  repertory.productId,product_info.productName,repertory.productSerialNo,repertory.enterSerialNo,product_info.marketPrice,product_info.productType,product_info.effectTime,repertory.productTime,repertory.productNum FROM repertory,product_info WHERE repertory.productId=product_info.pid  LIMIT ?,?;";
        return queryRunner.query(sql,new BeanListHandler<RepertoryList>(RepertoryList.class),pages.calCurPage(),pages.getPageSize());
    }
    //修改货物by流水号
    public Integer setRepertory(Repertory repertory,Integer productSerialNo) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="update repertory set productSerialNO=?,enterSerialNo=?,productNum=?,productTime=? where productSerialNO=?";
        return queryRunner.update(sql,repertory.getProductSerialNo(),repertory.getEnterSerialNo(),repertory.getProductNum(),repertory.getProductTime(),productSerialNo);
    }
}
