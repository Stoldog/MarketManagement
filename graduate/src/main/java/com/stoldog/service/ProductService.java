package com.stoldog.service;

import com.stoldog.daoImp.ProductDaoImp;
import com.stoldog.entity.Message;
import com.stoldog.entity.Pages;
import com.stoldog.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RL on 2017/4/15.
 */
@Service
public class ProductService {
    @Autowired
    private ProductDaoImp productDaoImp;


    //插入商品信息
    public Message entringProductInfo(List<ProductInfo> productInfoList) throws SQLException {
        //设置消息对象
        Message message=new Message();
        //插入数据
        int [] productInfoArray=productDaoImp.entringProductInfo(productInfoList);
        //将返回的数据存入message
        List plst=new ArrayList();
        for (int i :productInfoArray){
            plst.add(i);
        }
        message.setList(plst);
        message.setResult(true);
        message.setIsPaged(false);
        return message;
    }
    //返回商品类型列表
    public Message getProductType() throws SQLException {
        //设置消息对象
        Message message=new Message();
        List plist=productDaoImp.getProductType();
        message.setInfo("成功获取商品类型列表");
        message.setResult(true);
        message.setList(plist);
        message.setIsPaged(false);
        return message;
    }
    //返回商品信息列表
    public Message getInfo(Integer type,Integer curPage,ProductInfo productInfo) throws SQLException {
        List infoList=null;
        //设置消息对象
        Message message=new Message();
        //查询总数
        Pages pages=new Pages();
        pages.setPageNum(productDaoImp.getTableCount("product_info"));

        if(type==2){
            //需要分页查询
            infoList=productDaoImp.getProductInfoByType(curPage,productInfo);
        }else if(type==3){
            //需要分页查询
            infoList=productDaoImp.getProductInfoByCompany(curPage,productInfo);
        }else {
            //需要分页查询
            infoList=productDaoImp.getAllProductInfo(curPage);
        }
        message.setInfo("成功获取商品信息列表");
        message.setResult(true);
        message.setList(infoList);

        return message;
    }
    //返回键值对形式的商品列表
    public Message getInfoData() throws SQLException {
        //设置消息对象
        Message message=new Message();
        List productInfoList=productDaoImp.getProductInfoData();
        message.setList(productInfoList);
        message.setResult(true);
        return message;
    }
    //返回某个商品的信息
    public Message getInfoById(Integer pid) throws SQLException {
        //设置消息对象
        Message message=new Message();
        Object object=productDaoImp.getProductById(pid);
        message.setResult(true);
        message.setObject(object);
        return message;
    }

}
