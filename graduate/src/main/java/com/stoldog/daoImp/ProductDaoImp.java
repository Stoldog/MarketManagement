package com.stoldog.daoImp;

import com.stoldog.entity.ProductInfo;
import com.stoldog.entity.ProductType;
import com.stoldog.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RL on 2017/4/21.
 */
@Repository
public class ProductDaoImp extends CommonDaoImp{
    //录入商品信息
    public int[] entringProductInfo(List<ProductInfo> productInfolist) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into product_info(productName,stockPrice,effectTime,productType,marketPrice,productUnit,productCity,productCompany) values(?,?,?,?,?,?,?,?)";
        //获得长度
        int listLength=productInfolist.size();
        //传入的参数2维数组(前一个是长度后一个是需要传递的每个参数)
        Object[][] param= new Object[listLength][];
        //设置传入参数
        for(int i = 0 ; i < listLength ; i++){
            param[i]= new Object[7];
            param[i][0] = productInfolist.get(i).getProductName();
            param[i][1] = productInfolist.get(i).getStockPrice();
            param[i][2] = productInfolist.get(i).getEffectTime();
            param[i][3] = productInfolist.get(i).getProductType();
            param[i][4] = productInfolist.get(i).getMarketPrice();
            param[i][5] = productInfolist.get(i).getProductUnit();
            param[i][6] = productInfolist.get(i).getProductCity();
            param[i][7] = productInfolist.get(i).getProductCompany();
        }
        //执行并返回批量处理
        return queryRunner.batch(sql,param);

    }
    //返回商品类型
    public List<ProductType> getProductType() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT * FROM product_type";
        return queryRunner.query(sql,new BeanListHandler<ProductType>(ProductType.class));
    }
    //查找所有商品
    public List<ProductInfo> getAllProductInfo(Integer curPage) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT * FROM product_info LIMIT ?,10;";
        return queryRunner.query(sql,new BeanListHandler<ProductInfo>(ProductInfo.class),curPage);
    }
    //查找商品By商品类型
    public List<ProductInfo> getProductInfoByType(Integer curPage,ProductInfo productInfo) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product_info where productType=?";
        return queryRunner.query(sql,new BeanListHandler<ProductInfo>(ProductInfo.class),productInfo.getProductType());
    }
    //查找商品By生产厂家
    public List<ProductInfo> getProductInfoByCompany(Integer curPage,ProductInfo productInfo) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product_info where productCompany=?";
        return queryRunner.query(sql,new BeanListHandler<ProductInfo>(ProductInfo.class),productInfo.getProductCompany());
    }
    //查找商品Data
    public List<ProductInfo> getProductInfoData() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select pid,productName,effectTime from product_info";
        return queryRunner.query(sql,new BeanListHandler<ProductInfo>(ProductInfo.class));
    }
    //查找商品通过id
    public ProductInfo getProductById(Integer pid) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product_info where pid=?";
        return queryRunner.query(sql,new BeanHandler<ProductInfo>(ProductInfo.class),pid);
    }


}
