package com.stoldog.controller;

import com.stoldog.entity.Message;
import com.stoldog.entity.Sells;
import com.stoldog.entity.SellsSerial;
import com.stoldog.service.RepertoryService;
import com.stoldog.service.SellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by RL on 2017/4/27.
 */
@RestController
@RequestMapping("/sell")
public class SellsController {
    @Autowired
    private SellsService sellsService;
    @Autowired
    private RepertoryService repertoryService;
    //销售
    @RequestMapping(value = {"/sellProduct/{dateTime}/{totalPrice}"},method = {RequestMethod.POST})
    public Message sellingProduct(@PathVariable Long dateTime, @PathVariable Double totalPrice, @RequestBody List<Sells> sellsList, HttpSession httpSession) throws SQLException {

        //生产唯一ID并插入批次表
        SellsSerial sellsSerial=new SellsSerial();
        sellsSerial.setSellSerial(sellsService.getUUID());
        Integer userID= (Integer) httpSession.getAttribute("USER_ID");
        Integer getRe=sellsService.addSellSerial(sellsSerial.getSellSerial(),userID,dateTime,totalPrice);

        //执行销售操作
        if(getRe!=0){
            //新增销售操作
            sellsService.addSellsList(sellsList,sellsSerial);
            //删除库存
            repertoryService.reduceRepertory(userID,);
        }

    }
}
