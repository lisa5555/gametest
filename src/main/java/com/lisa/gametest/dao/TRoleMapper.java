package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TRole;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRoleMapper {
    int countByExample(TRole example);

    int deleteByExample(TRole example);

    int deleteByPrimaryKey(Integer rid);

    int insert(TRole record);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRole example);

    TRole selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRole example);

    int updateByExample(@Param("record") TRole record, @Param("example") TRole example);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
}