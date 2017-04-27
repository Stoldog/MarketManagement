package com.stoldog.daoImp;

import com.stoldog.entity.Sells;
import com.stoldog.entity.SellsSerial;
import com.stoldog.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RL on 2017/4/26.
 */
@Repository
public class SellDaoImp extends CommonDaoImp{
    //插入商品批次表
    public Integer setSellsSerial(SellsSerial sellsSerial){
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into sells_serial (sellSerial,sellTime,sellManId,sellTotalPrice) values(?,?,?,?)";
        Object [] params={sellsSerial.getSellSerial(),sellsSerial.getSellTime(),sellsSerial.getSellManId(),sellsSerial.getSellTotalPrice()};
        try {
            return queryRunner.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return 1;
    }
    //将某批次的销售数据插入销售表
    public int[] addSellsBySerialNo(List<Sells> sellsList,SellsSerial sellsSerial) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert info sells (productId,productMarketPrice,sellNum,productTotalPrice,sellSerial,productSerialNo) values(?,?,?,?,?,?,?)";
        Integer listlength=sellsList.size();
        Object[][] params=new Object[listlength][];
        //插入参数
        for(int i=0;i<listlength-1;i++){
            params[i]=new Object[6];
            params[i][0]=sellsList.get(i).getProductId();
            params[i][0]=sellsList.get(i).getProductMarketPrice();
            params[i][0]=sellsList.get(i).getSellNum();
            params[i][0]=sellsList.get(i).getProductTotalPrice();
            params[i][0]=sellsSerial.getSellSerial();
            params[i][0]=sellsList.get(i).getProductSerialNo();
        }
        return queryRunner.batch(sql,params);
    }
    //查询By批次号
/*
    public List<Sells> getSellsBySerialNo(SellsSerial sellsSerial){
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from sells where sellSerial=?";

    }
*/
}
