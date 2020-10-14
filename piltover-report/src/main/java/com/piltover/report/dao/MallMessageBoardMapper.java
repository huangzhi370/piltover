package com.piltover.report.dao;

import com.piltover.report.entity.MallMessageBoard;
import com.piltover.report.entity.MallMessageBoardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallMessageBoardMapper {
    long countByExample(MallMessageBoardExample example);

    int deleteByExample(MallMessageBoardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallMessageBoard record);

    int insertSelective(MallMessageBoard record);

    List<MallMessageBoard> selectByExample(MallMessageBoardExample example);

    MallMessageBoard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallMessageBoard record, @Param("example") MallMessageBoardExample example);

    int updateByExample(@Param("record") MallMessageBoard record, @Param("example") MallMessageBoardExample example);

    int updateByPrimaryKeySelective(MallMessageBoard record);

    int updateByPrimaryKey(MallMessageBoard record);
}