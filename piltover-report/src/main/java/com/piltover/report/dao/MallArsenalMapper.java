package com.piltover.report.dao;

import com.piltover.report.entity.MallArsenal;
import com.piltover.report.entity.MallArsenalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallArsenalMapper {
    long countByExample(MallArsenalExample example);

    int deleteByExample(MallArsenalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallArsenal record);

    int insertSelective(MallArsenal record);

    List<MallArsenal> selectByExample(MallArsenalExample example);

    MallArsenal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallArsenal record, @Param("example") MallArsenalExample example);

    int updateByExample(@Param("record") MallArsenal record, @Param("example") MallArsenalExample example);

    int updateByPrimaryKeySelective(MallArsenal record);

    int updateByPrimaryKey(MallArsenal record);
}