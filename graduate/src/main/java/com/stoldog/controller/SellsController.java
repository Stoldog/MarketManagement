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
    @RequestMapping(value = {"/sellProduct/{dateTime}/{totalPrice}/{totalNum}"},method = {RequestMethod.POST})
    public Message sellingProduct(@PathVariable Long dateTime, @PathVariable Double totalPrice, @RequestBody List<Sells> sellsList,@PathVariable Integer totalNum, HttpSession httpSession) throws SQLException {

        //生产唯一ID并插入批次表

        Integer userID= (Integer) httpSession.getAttribute("USER_ID");
        SellsSerial sellsSerial=new SellsSerial();
        sellsSerial.setSellSerial(sellsService.getUUID());
        sellsSerial.setSellManId(userID);
        Integer getRe=sellsService.addSellSerial(sellsSerial.getSellSerial(),sellsSerial.getSellManId(),dateTime,totalPrice,totalNum);
        //执行销售操作
        if(getRe!=0){
            //新增销售操作
            sellsService.addSellsList(sellsList,sellsSerial);

            //删除库存
            return repertoryService.reduceRepertory(sellsList);
        } else{
            return new Message();
        }

    }
    //销售业绩
    @RequestMapping(value = {"/sellPerformance/{uid}/{startTime}/{endTime}/{curPage}"},method = {RequestMethod.GET})
    public Message getSellingPerformance(@PathVariable Integer uid,@PathVariable Long startTime,@PathVariable Long endTime,@PathVariable Integer curPage) throws SQLException {
        return sellsService.getSellSerialBySellMan(startTime,endTime,uid,curPage);
    }
    //返回销售业绩图表数据
    @RequestMapping(value = {"/sellChart/{startTime}/{endTime}"},method = {RequestMethod.GET})
    public Message getSellChartByMonth(@PathVariable Long startTime,@PathVariable Long endTime) throws SQLException {
        return sellsService.getPerformanceByMonth(startTime, endTime);
    }
    //获得热销的产品和数量
    @RequestMapping(value = {"/hotSellChart/{startTime}/{endTime}"},method = {RequestMethod.GET})
    public Message getHotSellChart(@PathVariable Long startTime,@PathVariable Long endTime) throws SQLException {
        return sellsService.getHotSellChart(startTime,endTime);
    }

}
