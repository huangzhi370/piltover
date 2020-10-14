package com.piltover.user.dao;

import com.piltover.user.entity.MallRoleInfo;
import com.piltover.user.entity.MallRoleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallRoleInfoMapper {
    long countByExample(MallRoleInfoExample example);

    int deleteByExample(MallRoleInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallRoleInfo record);

    int insertSelective(MallRoleInfo record);

    List<MallRoleInfo> selectByExample(MallRoleInfoExample example);

    MallRoleInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallRoleInfo record, @Param("example") MallRoleInfoExample example);

    int updateByExample(@Param("record") MallRoleInfo record, @Param("example") MallRoleInfoExample example);

    int updateByPrimaryKeySelective(MallRoleInfo record);

    int updateByPrimaryKey(MallRoleInfo record);
}