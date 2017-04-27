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

    @Autowired
    private Message message;
    //调用登录方法
    public Message userCheck(User user)  {
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
}
