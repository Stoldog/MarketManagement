package com.stoldog.test;

import com.stoldog.daoImp.ProductDaoImp;
import com.stoldog.daoImp.RepertoryDaoImp;
import com.stoldog.entity.Pages;
import com.stoldog.entity.ProductInfo;
import com.stoldog.entity.RepertorySerial;
import com.stoldog.entity.User;
import com.stoldog.service.SellsService;
import com.stoldog.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by RL on 2017/4/6.
 */

public class JustTest {

    ProductDaoImp productDaoImp=new ProductDaoImp();
    RepertoryDaoImp repertoryDaoImp=new RepertoryDaoImp();
    public void te() throws SQLException {
        String sql="SELECT * FROM users";
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        User user = runner.query(sql,new BeanHandler<User>(User.class));
        System.out.println(user);

    }

    public void te2() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into test1(name, money) values(?,?)";
        Object[][] param= new Object[10][];
        for(int i=0; i<10; i++){
            param[i]= new Object[2];
            param[i][0] = "name"+i*10+0;
            param[i][1] = i*10+1;
        }
        int t[]=qr.batch(sql, param);
        for(int i=0;i<t.length;i++){
            System.out.println(t[i]);
        }
    }

    public void te3() throws SQLException {
        List<ProductInfo> s=new ArrayList<ProductInfo>();
        for(int i=0;i<5;i++){
            ProductInfo p=new ProductInfo();
            p.setProductName("高露洁牙膏"+i);
            p.setEffectTime(12);
            p.setStockPrice(3.5);
            p.setMarketPrice(4.5);
            p.setProductType(2);
            p.setProductUnit("支");
            p.setProductCity("长沙"+i);
            s.add(p);
        }
        productDaoImp.entringProductInfo(s);

    }

    public void te4() throws SQLException {

        Pages pages=new Pages();
        pages.setPageSize(5);
        pages.setCurPage(3);
        System.out.println(pages.calCurPage());
    }
    public Integer getpageNum(Integer a){
        if(a%10==0){
            return a/10;
        }else {
            return a/10+1;
        }
    }

    public void te5() throws SQLException {
        System.out.println(productDaoImp.getTableCount("product_info"));
    }

    public void te6() throws ParseException {
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat .parse("2010-06-25");
        long timeStemp = date.getTime();
        System.out.println(timeStemp );
    }

    public void te7() throws SQLException {
        Pages pages=new Pages();
        pages.setCurPage(1);
        List t=repertoryDaoImp.getRepertoryList(pages);

        for(Object object:t){
            System.out.println(object);
        }
    }
    public void te8(){
        SellsService sellsService=new SellsService();
        System.out.println(sellsService.getUUID());
    }
}
