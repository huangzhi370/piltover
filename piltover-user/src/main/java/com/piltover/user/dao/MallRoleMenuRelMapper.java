package com.piltover.user.dao;

import com.piltover.user.entity.MallRoleMenuRel;
import com.piltover.user.entity.MallRoleMenuRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallRoleMenuRelMapper {
    long countByExample(MallRoleMenuRelExample example);

    int deleteByExample(MallRoleMenuRelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallRoleMenuRel record);

    int insertSelective(MallRoleMenuRel record);

    List<MallRoleMenuRel> selectByExample(MallRoleMenuRelExample example);

    MallRoleMenuRel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallRoleMenuRel record, @Param("example") MallRoleMenuRelExample example);

    int updateByExample(@Param("record") MallRoleMenuRel record, @Param("example") MallRoleMenuRelExample example);

    int updateByPrimaryKeySelective(MallRoleMenuRel record);

    int updateByPrimaryKey(MallRoleMenuRel record);
}