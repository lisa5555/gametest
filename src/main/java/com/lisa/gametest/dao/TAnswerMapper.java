package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TAnswer;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAnswerMapper {
    int countByExample(TAnswer example);

    int deleteByExample(TAnswer example);

    int deleteByPrimaryKey(Integer aid);

    int insert(TAnswer record);

    int insertSelective(TAnswer record);

    List<TAnswer> selectByExample(TAnswer example);

    TAnswer selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") TAnswer record, @Param("example") TAnswer example);

    int updateByExample(@Param("record") TAnswer record, @Param("example") TAnswer example);

    int updateByPrimaryKeySelective(TAnswer record);

    int updateByPrimaryKey(TAnswer record);
}