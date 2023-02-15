package com.gzgs.service;

import com.gzgs.bean.*;
import com.gzgs.mapper.LogMapper;
import com.gzgs.mapper.RubbishMapper;
import com.gzgs.mapper.TransportMapper;
import com.gzgs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService{

    //获取UserMapper的对象
    @Autowired
    UserMapper userMapper;

    @Autowired
    LogMapper mapper;

    @Autowired
    RubbishMapper rubbishMapper;

    @Autowired
    TransportMapper transportMapper;
    public static User userNow=null;
    public static Log logNow=null;
    public User userLogin(User user) {
        //
        UserExample example = new UserExample();
        //
        UserExample.Criteria criteria = example.createCriteria();
        //添加条件
        criteria.andNameEqualTo(user.getName()).andPasswordEqualTo(user.getPassword());
        //根据用户名和密码进行查询
        List<User> list = userMapper.selectByExample(example);
        //判断结果集中是否有数据
        if (!list.isEmpty() && list.size() > 0) {
            userNow=user;

            return list.get(0);//返回第一个user数据
        } else {
            return null;
        }
    }

    public Integer userRegister(User user) {
        //判断数据库中是否存在这个用户
        int i=0;
        if (userLogin(user)==null&user.getPassword()!=""&user.getName()!=""&user.getId()!=null){
            User exitUser=new User();
            exitUser.setId(user.getId());
            exitUser.setName(user.getName());
            exitUser.setPassword(user.getPassword());
            i = userMapper.insertSelective(exitUser);
        }
        return i;
    }
public Log insertLogIn(User user) throws ParseException {
    Log log=new Log();
    log.setUid(user.getId());
    Date date=new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    String format = simpleDateFormat.format(date);
    log.setDate(simpleDateFormat.parse(format));
    log.setIp(new Random().nextInt(255)+"."+new Random().nextInt(255)+"."+new Random().nextInt(255)+"."+new Random().nextInt(255));
    log.setStatus(1);//  1为登入状态
    int insert = mapper.insert(log);
    if (insert==0){
        return null;
    }else {
        logNow=log;
        return log;
    }
}

    //退出时，把退出的相关信息写入到日志数据库中，因为退出和进入状态不一样，并且要保持ip相同
    public Integer insertLogOut(Log log) throws ParseException {
        int insert=0;
        if (log!=null){
            Log logOut=new Log();
            logOut.setUid(log.getUid());
            Date date=new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            String format = simpleDateFormat.format(date);
            logOut.setDate(simpleDateFormat.parse(format));
            logOut.setIp(log.getIp());
            logOut.setStatus(2);//   2为登出状态
            insert = mapper.insert(logOut);
        }
        return insert;
    }
    public Log getLog(){
        return logNow;
    }
    public void check(){
        LogExample logExample=new LogExample();
        LogExample.Criteria criteria=logExample.createCriteria();
        criteria.andUidIsNotNull();
        List<Log> logs = mapper.selectByExample(logExample);
        if (logs.size()==1){
            Rubbish rubbish=new Rubbish();
            rubbish.setUid(logs.get(0).getUid());
            rubbish.setDate(logs.get(0).getDate());
            rubbish.setIp(logs.get(0).getIp());
            rubbishMapper.insert(rubbish);
            LogExample logExample1=new LogExample();
            LogExample.Criteria criteria1=logExample1.createCriteria();
            criteria1.andUidEqualTo(logs.get(0).getUid()).andDateEqualTo(logs.get(0).getDate()).andStatusEqualTo(logs.get(0).getStatus());
            mapper.deleteByExample(logExample1);
            return;
        }
        if (logs.get(0).getStatus()==2){
            Rubbish rubbish=new Rubbish();
            rubbish.setUid(logs.get(0).getUid());
            rubbish.setDate(logs.get(0).getDate());
            rubbish.setIp(logs.get(0).getIp());
            rubbishMapper.insert(rubbish);
            LogExample logExample1=new LogExample();
            LogExample.Criteria criteria1=logExample1.createCriteria();
            criteria1.andUidEqualTo(logs.get(0).getUid()).andDateEqualTo(logs.get(0).getDate()).andStatusEqualTo(logs.get(0).getStatus());
            mapper.deleteByExample(logExample1);
            logs.remove(logs.get(0));
        }
        if (logs.get(logs.size()-1).getStatus()==1){
            Rubbish rubbish=new Rubbish();
            rubbish.setUid(logs.get(logs.size()-1).getUid());
            rubbish.setDate(logs.get(logs.size()-1).getDate());
            rubbish.setIp(logs.get(logs.size()-1).getIp());
            rubbishMapper.insert(rubbish);
            LogExample logExample1=new LogExample();
            LogExample.Criteria criteria1=logExample1.createCriteria();
            criteria1.andUidEqualTo(logs.get(logs.size()-1).getUid()).andDateEqualTo(logs.get(logs.size()-1).getDate()).andStatusEqualTo(logs.get(logs.size()-1).getStatus());
            mapper.deleteByExample(logExample1);
            logs.remove(logs.get(logs.size()-1));
        }
        for (int i=0;i<logs.size()-1;i++) {
            if (logs.get(i).getIp()==""||logs.get(i).getUid()==null||logs.get(i).getDate()==null||logs.get(i).getStatus()==null||(i==0&&logs.get(i).getStatus()==2||i==logs.size()-1&&logs.get(logs.size()-1).getStatus()==1)){
                Rubbish rubbish=new Rubbish();
                rubbish.setUid(logs.get(i).getUid());
                rubbish.setDate(logs.get(i).getDate());
                rubbish.setIp(logs.get(i).getIp());
                rubbishMapper.insert(rubbish);
                LogExample logExample1=new LogExample();
                LogExample.Criteria criteria1=logExample1.createCriteria();
                criteria1.andUidEqualTo(logs.get(i).getUid()).andDateEqualTo(logs.get(i).getDate()).andStatusEqualTo(logs.get(i).getStatus());
                mapper.deleteByExample(logExample1);
                continue;
            }
            if (logs.get(i).getStatus()==logs.get(i+1).getStatus()){
                if (logs.get(i).getStatus()==1){
                    LogExample logExample1=new LogExample();
                    LogExample.Criteria criteria1=logExample1.createCriteria();
                    criteria1.andUidEqualTo(logs.get(i).getUid()).andDateEqualTo(logs.get(i).getDate()).andStatusEqualTo(logs.get(i).getStatus());
                    int i1 = mapper.deleteByExample(logExample1);
                    Rubbish rubbish=new Rubbish();
                    rubbish.setUid(logs.get(i).getUid());
                    rubbish.setDate(logs.get(i).getDate());
                    rubbish.setIp(logs.get(i).getIp());
                    rubbishMapper.insert(rubbish);

                    continue;
                }
                if (logs.get(i).getStatus()==2){
                    LogExample logExample1=new LogExample();
                    LogExample.Criteria criteria1=logExample1.createCriteria();
                    criteria1.andUidEqualTo(logs.get(i+1).getUid()).andDateEqualTo(logs.get(i+1).getDate()).andStatusEqualTo(logs.get(i+1).getStatus());
                    int i1 = mapper.deleteByExample(logExample1);
                    Rubbish rubbish=new Rubbish();
                    rubbish.setUid(logs.get(i).getUid());
                    rubbish.setDate(logs.get(i).getDate());
                    rubbish.setIp(logs.get(i).getIp());
                    rubbishMapper.insert(rubbish);
                    continue;
                }
            }
        }
    }
    public List<Transport> selectById(User user){
        TransportExample transportExample =new TransportExample();

        TransportExample.Criteria criteria = transportExample.createCriteria().andUidEqualTo(user.getId());
        //查询到id匹配的数据添加到集合循环遍历
        List<Transport> userlist = transportMapper.selectByExample(transportExample);
        return userlist;
    }

    public List<Log> selectLogById(User user){
        LogExample logExample =new LogExample();
        LogExample.Criteria criteria = logExample.createCriteria().andUidEqualTo(user.getId());
        //查询到id匹配的数据添加到集合循环遍历
        List<Log> userlist = mapper.selectByExample(logExample);
        return userlist;
    }
}
