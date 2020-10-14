package com.piltover.user.dao;

import com.piltover.user.entity.MallUserRoleRel;
import com.piltover.user.entity.MallUserRoleRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallUserRoleRelMapper {
    long countByExample(MallUserRoleRelExample example);

    int deleteByExample(MallUserRoleRelExample example);

    int insert(MallUserRoleRel record);

    int insertSelective(MallUserRoleRel record);

    List<MallUserRoleRel> selectByExample(MallUserRoleRelExample example);

    int updateByExampleSelective(@Param("record") MallUserRoleRel record, @Param("example") MallUserRoleRelExample example);

    int updateByExample(@Param("record") MallUserRoleRel record, @Param("example") MallUserRoleRelExample example);
}