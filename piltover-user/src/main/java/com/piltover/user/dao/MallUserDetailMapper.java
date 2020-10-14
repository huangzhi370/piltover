package com.piltover.user.dao;

import com.piltover.user.entity.MallUserDetail;
import com.piltover.user.entity.MallUserDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallUserDetailMapper {
    long countByExample(MallUserDetailExample example);

    int deleteByExample(MallUserDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallUserDetail record);

    int insertSelective(MallUserDetail record);

    List<MallUserDetail> selectByExample(MallUserDetailExample example);

    MallUserDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallUserDetail record, @Param("example") MallUserDetailExample example);

    int updateByExample(@Param("record") MallUserDetail record, @Param("example") MallUserDetailExample example);

    int updateByPrimaryKeySelective(MallUserDetail record);

    int updateByPrimaryKey(MallUserDetail record);
}