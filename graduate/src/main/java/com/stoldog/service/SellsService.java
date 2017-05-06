package com.stoldog.service;

import com.stoldog.daoImp.SellDaoImp;
import com.stoldog.daoImp.UserDaoImp;
import com.stoldog.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Created by RL on 2017/4/27.
 */
@Service
public class SellsService {
    @Autowired
    private SellDaoImp sellDaoImp;
    //生成唯一ID
    public String getUUID(){
        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }
    //插入销售批次表
    public int addSellSerial(String uuid,Integer userId,Long dateTime,Double totalPirce,Integer totalNum){
        SellsSerial sellsSerial=new SellsSerial();
        sellsSerial.setSellSerial(uuid);
        sellsSerial.setSellManId(userId);
        sellsSerial.setSellTime(dateTime);
        sellsSerial.setSellTotalPrice(totalPirce);
        sellsSerial.setTotalNum(totalNum);
        return sellDaoImp.setSellsSerial(sellsSerial);
    }
    //插入商品列表
    public int[] addSellsList(List<Sells> sellsList,SellsSerial sellsSerial) throws SQLException {
        return sellDaoImp.addSellsBySerialNo(sellsList,sellsSerial);
    }
    //查询营业员业绩
    public Message getSellSerialBySellMan(Long startTime,Long endTime,Integer uid,Integer curPage) throws SQLException {
        //生成消息对象
        Message message=new Message();
        Pages pages=new Pages();
        pages.setCurPage(curPage);
        //执行查询
        List sellSeriallist=sellDaoImp.getSellSerialByMonth(startTime,endTime,uid,pages);
        message.setList(sellSeriallist);
        message.setResult(true);
        pages.calPageNum((long) sellSeriallist.size());
        message.setPage(pages);
        return message;
    }
    //查询季度业绩
    public Message getPerformanceByMonth(Long startTime,Long endTime) throws SQLException {
        //生成消息对象
        Message message=new Message();
        message.setList(sellDaoImp.getSellManChartsByMonth(startTime,endTime));
        return message;
    }
    //查询热销产品和数量
    public Message getHotSellChart(Long startTime,Long endTime) throws SQLException {
        //生成消息对象
        Message message=new Message();
        message.setList(sellDaoImp.getHotSellChart(startTime, endTime));
        return message;
    }
}
