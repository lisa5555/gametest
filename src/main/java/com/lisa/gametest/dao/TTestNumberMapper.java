package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TTestNumber;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTestNumberMapper {
    int countByExample(TTestNumber example);

    int deleteByExample(TTestNumber example);

    int deleteByPrimaryKey(Integer kid);

    int insert(TTestNumber record);

    int insertSelective(TTestNumber record);

    List<TTestNumber> selectByExample(TTestNumber example);

    TTestNumber selectByPrimaryKey(Integer kid);

    int updateByExampleSelective(@Param("record") TTestNumber record, @Param("example") TTestNumber example);

    int updateByExample(@Param("record") TTestNumber record, @Param("example") TTestNumber example);

    int updateByPrimaryKeySelective(TTestNumber record);

    int updateByPrimaryKey(TTestNumber record);
}