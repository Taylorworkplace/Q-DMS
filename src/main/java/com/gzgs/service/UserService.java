package com.gzgs.service;

import com.gzgs.bean.Log;
import com.gzgs.bean.Transport;
import com.gzgs.bean.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {
    //登入
    public User userLogin(User user);
    //注册
    public Integer userRegister(User user);
    //出入登入日志
    public Log insertLogIn(User user) throws ParseException;
    //插入登出日志
    public Integer insertLogOut(Log log) throws ParseException;
    public Log getLog();
    public List<Transport> selectById(User user);
    public void check();
    public List<Log> selectLogById(User user);
}
