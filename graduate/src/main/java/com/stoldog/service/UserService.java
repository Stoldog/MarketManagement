package com.stoldog.service;

import com.stoldog.dao.UserDao;
import com.stoldog.daoImp.UserDaoImp;
import com.stoldog.entity.Message;
import com.stoldog.entity.Pages;
import com.stoldog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RL on 2017/4/8.
 */
@Service("userService")
public class UserService {
    @Autowired
    @Qualifier("userDao")
    private UserDaoImp userDao;
    //调用登录方法
    public Message userCheck(User user)  {
      Message message=new Message();
        //查询数据
        User getUser;
        try {
            getUser = userDao.userCheck(user);
        } catch (SQLException e) {
            e.printStackTrace();
            message.setResult(false);
            message.setInfo("查询失败，未查到数据");
            return message;
        }
        //将查询的数据放入Message
        message.setObject(getUser);
        message.setResult(true);
        message.setInfo("查询成功!");
        message.setIsPaged(false);
        return message;
    }
    //查询所有的销售员
    public Message getSellManList() throws SQLException {
        //生成消息对象
        Message message=new Message();
        message.setList(userDao.getSellManList());
        message.setResult(true);
        return message;
    }
    //查询职务列表
    public Message getDepartList() throws SQLException {
        //生成消息对象
        Message message=new Message();
        message.setList(userDao.getDepartList());
        return message;
    }
    //查询用户
    public Message getUserByDepartType(Integer departType) throws SQLException {
        //生成消息对象
        Message message=new Message();
        if(departType==-1){
            message.setList(userDao.getAllUsers());
        }else {
            message.setList(userDao.getUsersByDepartType(departType));
        }
        message.setResult(true);
        return message;
    }
    //编辑用户
    public Message editUser(User user) throws SQLException {
        //生成消息对象
        Message message=new Message();
        //修改用户
        Integer getRes=userDao.editUser(user);
        if(getRes!=0){
            message.setResult(true);
        }else {
            message.setResult(false);
        }
        return message;
    }
    //删除用户
    public Message delUser(Integer uid) throws SQLException {
        //生成消息对象
        Message message=new Message();
        //修改用户
        Integer getRes=userDao.delUser(uid);
        if(getRes!=0){
            message.setResult(true);
        }else {
            message.setResult(false);
        }
        return message;
    }
}
