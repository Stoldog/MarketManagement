package com.stoldog.service;

import com.stoldog.daoImp.RepertoryDaoImp;
import com.stoldog.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RL on 2017/4/18.
 */
@Service
public class RepertoryService {
    @Autowired
    private RepertoryDaoImp repertoryDaoImp;
    //商品录入
    public Message enteringRepertory(User user, List<Repertory> repertoryList, Long date) throws SQLException {
        //生成消息对象
        Message message=new Message();
        //生成入仓库号
        RepertorySerial repertorySerial= repertoryDaoImp.getRepertorySerial(user.getUid(),user.getUsername(),date);
        List list=new ArrayList();
        int [] listRepertory=repertoryDaoImp.entringRepertory(repertorySerial,repertoryList);
        for(int i:listRepertory){
            list.add(i);
        }
        //插入
        message.setResult(true);
        message.setList(list);
        return message;
    }
    //查找商品
    public Message getRepertoryList(Pages pages,Repertory object) throws SQLException {
        //生成消息对象
        Message message=new Message();
        List o=new ArrayList();
        Long pageNum=pages.calPageNum(repertoryDaoImp.getTableCount("repertory"));
        pages.setPageNum(pageNum);

        if(object.getEnterSerialNo()!=null&&object.getProductNum()==null){
            o=repertoryDaoImp.getRepertoryByEnterSerialNo(object,pages);
        }else if(object.getProductNum()!=null&&object.getEnterSerialNo()==null){
            o=repertoryDaoImp.getRepertoryLessThanProductNum(object,pages);
        }else {
            o=repertoryDaoImp.getRepertoryList(pages);
        }
        //查询所有数据
        message.setList(o);
        message.setPage(pages);
        return message;
    }
}
