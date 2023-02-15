package com.gzgs.controller;


import com.gzgs.bean.Log;
import com.gzgs.bean.Transport;
import com.gzgs.bean.User;
import com.gzgs.service.UserService;
import com.gzgs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

@Controller
public class LogController {

    @Autowired(required = false)
    UserService userService;



    //退出系统，将退出的信息发送给日志数据库
    @RequestMapping("/exit")
    public String exit() throws ParseException {
        Log logNow = userService.getLog();
        Integer integer = userService.insertLogOut(logNow);
        if (integer!=0){
            userService.check();
            return "login";
        }
        return "login";
    }
    @RequestMapping("/transport")
    public String select(Model model){
        User userNow = UserServiceImpl.userNow;
        System.out.println("此时的user为："+userNow.getId()+"++++++++++++++++++");
        List<Transport> list = userService.selectById(userNow);
        System.out.println("乌拉乌啊乌拉+++++"+list.size());
        model.addAttribute("userList",list);
        return "transport";
    }

}
