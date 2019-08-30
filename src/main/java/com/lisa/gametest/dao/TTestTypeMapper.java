package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TTestType;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTestTypeMapper {

    int insert(TTestType tTestType);

    TTestType findByName(String typeName);



    int countByExample(TTestType example);

    int deleteByExample(TTestType example);

    int deleteByPrimaryKey(Integer tid);



    int insertSelective(TTestType record);

    List<TTestType> selectByExample(TTestType example);

    TTestType selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TTestType record, @Param("example") TTestType example);

    int updateByExample(@Param("record") TTestType record, @Param("example") TTestType example);

    int updateByPrimaryKeySelective(TTestType record);

    int updateByPrimaryKey(TTestType record);
}