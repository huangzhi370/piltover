package com.piltover.user.dao;

import com.piltover.user.entity.MallMenuInfo;
import com.piltover.user.entity.MallMenuInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallMenuInfoMapper {
    long countByExample(MallMenuInfoExample example);

    int deleteByExample(MallMenuInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallMenuInfo record);

    int insertSelective(MallMenuInfo record);

    List<MallMenuInfo> selectByExample(MallMenuInfoExample example);

    MallMenuInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallMenuInfo record, @Param("example") MallMenuInfoExample example);

    int updateByExample(@Param("record") MallMenuInfo record, @Param("example") MallMenuInfoExample example);

    int updateByPrimaryKeySelective(MallMenuInfo record);

    int updateByPrimaryKey(MallMenuInfo record);
}