package com.gzgs.mapper;

import com.gzgs.bean.Transport;
import com.gzgs.bean.TransportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransportMapper {
    int countByExample(TransportExample example);

    int deleteByExample(TransportExample example);

    int insert(Transport record);

    int insertSelective(Transport record);

    List<Transport> selectByExample(TransportExample example);

    int updateByExampleSelective(@Param("record") Transport record, @Param("example") TransportExample example);

    int updateByExample(@Param("record") Transport record, @Param("example") TransportExample example);
}