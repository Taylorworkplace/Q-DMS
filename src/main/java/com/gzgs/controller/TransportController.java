package com.gzgs.controller;

import com.gzgs.bean.User;
import com.gzgs.service.TransportService;
import com.gzgs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TransportController {
    @Autowired(required = false)
    TransportService service;

    @RequestMapping("/shopping")
    public String shopping(HttpServletRequest request){
        User userNow = UserServiceImpl.userNow;
        Integer shopping = service.shopping(userNow);
        if (shopping==0){
            request.setAttribute("message","购物失败");
            return "index";
        }else{
            request.setAttribute("message","购物成功，可查看物流信息");
            return "index";
        }
    }

}
