package com.gzgs.service;

import com.gzgs.bean.Transport;
import com.gzgs.bean.User;
import com.gzgs.mapper.TransportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TransportServiceImpl implements TransportService{

    @Autowired
    TransportMapper mapper;

    public Integer shopping(User user) {
        String[] addresss={"广东","吉林","四川","北京","山西","广西","江西","浙江"};
        String[] handlers={"张三","李四","王五","赵六","陆琪","娃尔","4k"};
        String[] statuss={"运送中","未发货","已送达"};
        int i=0;

        if (user!=null){
           for (int j=0;j<4;j++){
               Transport transport=new Transport();
               transport.setUid(user.getId());
               transport.setGoods(user.getName()+"的商品"+j);
               transport.setHandler(handlers[new Random().nextInt(handlers.length)]);
               transport.setAddress(addresss[new Random().nextInt(addresss.length)]);
               transport.setStatus(statuss[new Random().nextInt(statuss.length)]);
                i=mapper.insert(transport);
           }
        }
        return i;
    }

}
