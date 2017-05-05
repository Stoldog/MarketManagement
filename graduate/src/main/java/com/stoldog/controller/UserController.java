package com.stoldog.controller;

import com.stoldog.entity.Message;
import com.stoldog.entity.User;
import com.stoldog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RL on 2017/4/7.
 */
@RestController
@SessionAttributes({"LOGINSTATUS","PERMIT","USER_NAME","USER_ID"})
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/manage/login",method = {RequestMethod.POST})
    public Message loginIn(@RequestBody User user,HttpSession session) throws SQLException {
        Message message=userService.userCheck(user);
        User users= (User) message.getObject();
        session.setAttribute("LOGINSTATUS",message.getResult());
        session.setAttribute("USER_ID",users.getUid());
        session.setAttribute("USER_NAME",users.getUsername());
        return message;
    }
    //
    @RequestMapping(value = {"/manage/getSession"},method = {RequestMethod.GET})
    public Message getSession(HttpSession session){
        Message message=new Message();
        List list=new ArrayList();

        list.add(session.getAttribute("LOGINSTATUS"));
        list.add(session.getAttribute("USER_NAME"));
        list.add(session.getAttribute("USER_ID"));
        list.add(session.getAttribute("PERMIT"));
        message.setList(list);
        return message;
    }
    //获得营业员列表
    @RequestMapping(value = {"/user/getSellManList"},method = {RequestMethod.GET})
    public Message getSellManList() throws SQLException {
        return userService.getSellManList();
    }
    //获得职务键值对
    @RequestMapping(value = {"/user/getDepartList"},method = {RequestMethod.GET})
    public Message getDepartList() throws SQLException {
        return userService.getDepartList();
    }
    //获得用户列表By职务
    @RequestMapping(value = {"/user/getUserByDepartType/{departType}"},method = {RequestMethod.GET})
    public Message getUserByDepartType(@PathVariable Integer departType) throws SQLException {
        //判断是否是查询所有的
        return userService.getUserByDepartType(departType);
    }
    //修改用户
    @RequestMapping(value = {"/user/editUser"},method = {RequestMethod.POST})
    public Message editUser(@RequestBody User user) throws SQLException {
        return userService.editUser(user);
    }
    //删除用户
    @RequestMapping(value = {"/user/delUser/{uid}"},method = {RequestMethod.GET})
    public Message editUser(@PathVariable Integer uid) throws SQLException {
        return userService.delUser(uid);
    }
}
