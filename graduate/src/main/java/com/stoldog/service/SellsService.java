package com.stoldog.service;

import com.stoldog.daoImp.SellDaoImp;
import com.stoldog.daoImp.UserDaoImp;
import com.stoldog.entity.Message;
import com.stoldog.entity.Sells;
import com.stoldog.entity.SellsSerial;
import com.stoldog.entity.User;
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
    public int addSellSerial(String uuid,Integer userId,Long dateTime,Double totalPirce){
        SellsSerial sellsSerial=new SellsSerial();
        sellsSerial.setSellSerial(uuid);
        sellsSerial.setSellManId(userId);
        sellsSerial.setSellTime(dateTime);
        sellsSerial.setSellTotalPrice(totalPirce);
        return sellDaoImp.setSellsSerial(sellsSerial);
    }
    //插入商品列表
    public int[] addSellsList(List<Sells> sellsList,SellsSerial sellsSerial) throws SQLException {
        return sellDaoImp.addSellsBySerialNo(sellsList,sellsSerial);
    }
    //查询营业员业绩
    public Message getSellSerialBySellMan(User user) throws SQLException {
        //生成消息对象
        Message message=new Message();
        //执行查询
        message.setList(sellDaoImp.getSellSerialBySellman(user.getUid()));
        message.setResult(true);
        return message;
    }
}
