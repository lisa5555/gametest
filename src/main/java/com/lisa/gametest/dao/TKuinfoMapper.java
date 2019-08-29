package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TKuinfo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TKuinfoMapper {
    int countByExample(TKuinfo example);

    int deleteByExample(TKuinfo example);

    int deleteByPrimaryKey(Integer kinfoid);

    int insert(TKuinfo record);

    int insertSelective(TKuinfo record);

    List<TKuinfo> selectByExample(TKuinfo example);

    TKuinfo selectByPrimaryKey(Integer kinfoid);

    int updateByExampleSelective(@Param("record") TKuinfo record, @Param("example") TKuinfo example);

    int updateByExample(@Param("record") TKuinfo record, @Param("example") TKuinfo example);

    int updateByPrimaryKeySelective(TKuinfo record);

    int updateByPrimaryKey(TKuinfo record);
}