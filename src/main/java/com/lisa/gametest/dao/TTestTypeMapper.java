package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TTestType;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTestTypeMapper {

    List<TTestType> findAll();

    int insertTTestType(TTestType tTestType);

    TTestType findByName(String typeName);

    TTestType findById(Integer tid);

    int deleteTTestType(Integer tid);

    int deleteTTestTypeByIds(String[] arr);

    List<TTestType> selectBySearch(String searchName);

    int updateTTestType(TTestType tTestType);

}