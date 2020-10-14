package com.piltover.user.dao;

import com.piltover.user.entity.MallUserLog;
import com.piltover.user.entity.MallUserLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallUserLogMapper {
    long countByExample(MallUserLogExample example);

    int deleteByExample(MallUserLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallUserLog record);

    int insertSelective(MallUserLog record);

    List<MallUserLog> selectByExample(MallUserLogExample example);

    MallUserLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallUserLog record, @Param("example") MallUserLogExample example);

    int updateByExample(@Param("record") MallUserLog record, @Param("example") MallUserLogExample example);

    int updateByPrimaryKeySelective(MallUserLog record);

    int updateByPrimaryKey(MallUserLog record);
}