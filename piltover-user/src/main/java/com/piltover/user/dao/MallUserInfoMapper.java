package com.piltover.user.dao;

import com.piltover.user.entity.MallMenuInfo;
import com.piltover.user.entity.MallUserInfo;
import com.piltover.user.entity.MallUserInfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MallUserInfoMapper {
    long countByExample(MallUserInfoExample example);

    int deleteByExample(MallUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallUserInfo record);

    int insertSelective(MallUserInfo record);

    List<MallUserInfo> selectByExample(MallUserInfoExample example);

    MallUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallUserInfo record, @Param("example") MallUserInfoExample example);

    int updateByExample(@Param("record") MallUserInfo record, @Param("example") MallUserInfoExample example);

    int updateByPrimaryKeySelective(MallUserInfo record);

    int updateByPrimaryKey(MallUserInfo record);
    
    List<MallMenuInfo> queryMenu(Map<String,Object> param);
}