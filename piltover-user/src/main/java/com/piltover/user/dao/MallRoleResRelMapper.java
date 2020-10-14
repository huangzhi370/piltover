package com.piltover.user.dao;

import com.piltover.user.entity.MallRoleResRel;
import com.piltover.user.entity.MallRoleResRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallRoleResRelMapper {
    long countByExample(MallRoleResRelExample example);

    int deleteByExample(MallRoleResRelExample example);

    int insert(MallRoleResRel record);

    int insertSelective(MallRoleResRel record);

    List<MallRoleResRel> selectByExample(MallRoleResRelExample example);

    int updateByExampleSelective(@Param("record") MallRoleResRel record, @Param("example") MallRoleResRelExample example);

    int updateByExample(@Param("record") MallRoleResRel record, @Param("example") MallRoleResRelExample example);
}