package com.gzgs.service;

import com.gzgs.bean.*;
import com.gzgs.mapper.LogMapper;
import com.gzgs.mapper.RubbishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class LogServiceImpl {

    @Autowired
    LogMapper mapper;

    @Autowired
    RubbishMapper rubbishMapper;

    public static Log logNow=null;
    public Log getLog(){
        return logNow;
    }

    public void check(){
        LogExample logExample=new LogExample();
        LogExample.Criteria criteria=logExample.createCriteria();
        criteria.andUidIsNotNull();
        List<Log> logs = mapper.selectByExample(logExample);

        for (int i=0;i<logs.size()-1;i++) {
            if (logs.get(i).getIp()==""||logs.get(i).getUid()==null||logs.get(i).getDate()==null||logs.get(i).getStatus()==null){
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
                    mapper.deleteByExample(logExample1);
                    continue;
                }
                if (logs.get(i).getStatus()==2){
                    LogExample logExample1=new LogExample();
                    LogExample.Criteria criteria1=logExample1.createCriteria();
                    criteria1.andUidEqualTo(logs.get(i+1).getUid()).andDateEqualTo(logs.get(i+1).getDate()).andStatusEqualTo(logs.get(i+1).getStatus());
                    mapper.deleteByExample(logExample1);
                    continue;
                }
            }
        }
    }

}
