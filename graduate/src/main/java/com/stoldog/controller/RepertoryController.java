package com.stoldog.controller;

import com.stoldog.entity.Message;
import com.stoldog.entity.Pages;
import com.stoldog.entity.Repertory;
import com.stoldog.entity.User;
import com.stoldog.service.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by RL on 2017/4/18.
 */
@RestController
@RequestMapping("/repertory")
public class RepertoryController {
    @Autowired
    private RepertoryService repertoryService;
    @RequestMapping(value = {"/addStock/{date}"},method = RequestMethod.POST)
    public Message enteringRepertory(@PathVariable Long date ,@RequestBody List<Repertory> repertoryList, HttpSession httpSession) throws SQLException {
        User user=new User();
        user.setUid((Integer) httpSession.getAttribute("USER_ID"));
        user.setUsername((String) httpSession.getAttribute("USER_NAME"));

        return repertoryService.enteringRepertory(user,repertoryList,date);
    }
    //查询所有在库商品
    @RequestMapping(value = {"/getRepertoryList/{curPage}"},method = {RequestMethod.POST})
    public Message getRepertoryList(@PathVariable Integer curPage,@RequestBody Repertory repertory) throws SQLException {
        Pages pages=new Pages();
        pages.setCurPage(curPage);
        System.out.println(repertory);
        return repertoryService.getRepertoryList(pages,repertory);
    }
}
