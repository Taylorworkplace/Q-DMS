package com.gzgs.mapper;

import com.gzgs.bean.Rubbish;
import com.gzgs.bean.RubbishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface RubbishMapper {
    int countByExample(RubbishExample example);

    int deleteByExample(RubbishExample example);

    int insert(Rubbish record);

    int insertSelective(Rubbish record);

    List<Rubbish> selectByExample(RubbishExample example);

    int updateByExampleSelective(@Param("record") Rubbish record, @Param("example") RubbishExample example);

    int updateByExample(@Param("record") Rubbish record, @Param("example") RubbishExample example);
}