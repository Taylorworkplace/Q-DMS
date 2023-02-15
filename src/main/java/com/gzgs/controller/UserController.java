package com.gzgs.controller;

import com.gzgs.bean.Log;
import com.gzgs.bean.User;
import com.gzgs.service.UserService;
import com.gzgs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
public class UserController {
    //获取业务层的对象
    @Autowired(required = false)
    UserService userService;
    //登录请求处理
    @RequestMapping(value = "/userLogin",params ="login=登录")
    public String login(User user, HttpServletRequest request) throws ParseException {
        if (user.getName()==""||user.getId()==null||user.getPassword()==""){
            request.setAttribute("message","信息不能为空");
            return "login";
        }
        //调用业务层方法查询用户
        User loginUser = userService.userLogin(user);
        //简单的判断
        if (loginUser!=null) {//登录成功
            //跳转到首页
            userService.insertLogIn(user);
            return "index";
        } else {//登录失败的
            // 登录页面
            request.setAttribute("message","账号或者密码错误");
            return "login";
        }
    }
    //注册请求处理
    @RequestMapping(value = "/userLogin",params ="register=注册")
    public String register(User user,HttpServletRequest request) {
        if (user.getName()==""||user.getId()==null||user.getPassword()==""){
            request.setAttribute("message","用户名不能为空");
            return "login";
        }

        Integer integer = userService.userRegister(user);
        if (integer == 0) {
            request.setAttribute("message","用户已存在");
            return "login";
        } else {
            request.setAttribute("message","注册成功，请登录");
            return "login";
        }
    }

    @RequestMapping("/log")
    public String checkLog(Model model){
        User userNow = UserServiceImpl.userNow;
        System.out.println("此时的user为："+userNow.getId()+"++++++++++++++++++");
        List<Log> list = userService.selectLogById(userNow);
        System.out.println("乌拉乌啊乌拉+++++"+list.size());
        model.addAttribute("userList",list);
        return "log";
    }
}
