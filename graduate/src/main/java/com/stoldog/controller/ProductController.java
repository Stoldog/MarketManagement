package com.stoldog.controller;

import com.stoldog.entity.Message;
import com.stoldog.entity.ProductInfo;
import com.stoldog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by RL on 2017/4/15.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    //插入商品信息
    @RequestMapping(value = {"/addInfo"},method = {RequestMethod.POST},produces = {"application/json"})
    public Message addProductInfoList(@RequestBody List<ProductInfo> productInfoList, HttpSession session) throws SQLException {
        for(ProductInfo productInfo:productInfoList){
            System.out.println(productInfo);
        }
        return productService.entringProductInfo(productInfoList);

    }
    //获得商品类型
    @RequestMapping(value = {"/getType"},method = {RequestMethod.GET})
    public Message getProductType() throws SQLException {
        return productService.getProductType();
    }
    //获得商品列表
    @RequestMapping(value = {"/getInfo/{type}/{curPage}"},method = {RequestMethod.POST})
    public Message getProductInfo(@PathVariable Integer type,@PathVariable Integer curPage,@RequestBody ProductInfo productInfo) throws SQLException {
        //获得参数
        return productService.getInfo(type,curPage,productInfo);
    }
    //获取商品列表（键值对形式）
    @RequestMapping(value = {"/getInfoData"},method = {RequestMethod.GET})
    public Message getProductInfoData() throws SQLException {
        return productService.getInfoData();
    }
    //获取单个商品信息ById
    @RequestMapping(value = {"/getInfo/{productId}"},method = {RequestMethod.GET})
    public Message getProductById(@PathVariable String productId) throws SQLException {
        return productService.getInfoById(Integer.parseInt(productId));
    }

}
