package com.stoldog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by RL on 2017/5/6.
 */
@Controller
public class ViewController {
    //跳转到登陆页面
    @RequestMapping(value = {"/","login"},method = {RequestMethod.GET})
    public String viewLogin(){
        return "login";
    }
   //跳转到主界面
    @RequestMapping(value = {"/home"},method = {RequestMethod.GET})
    public String viewIndex(HttpSession session){
        Boolean b = (Boolean) session.getAttribute("LOGINSTATUS");
        if(b){
            return "index";
        }else {
            return "login";
        }

    }

}
