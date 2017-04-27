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
        session.setAttribute("PERMIT",users.getPermit());
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
}
