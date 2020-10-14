package com.piltover.user.dao;

import com.piltover.user.entity.MallResourceInfo;
import com.piltover.user.entity.MallResourceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallResourceInfoMapper {
    long countByExample(MallResourceInfoExample example);

    int deleteByExample(MallResourceInfoExample example);

    int insert(MallResourceInfo record);

    int insertSelective(MallResourceInfo record);

    List<MallResourceInfo> selectByExample(MallResourceInfoExample example);

    int updateByExampleSelective(@Param("record") MallResourceInfo record, @Param("example") MallResourceInfoExample example);

    int updateByExample(@Param("record") MallResourceInfo record, @Param("example") MallResourceInfoExample example);
}