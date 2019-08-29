package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TPermision;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPermisionMapper {
    int countByExample(TPermision example);

    int deleteByExample(TPermision example);

    int deleteByPrimaryKey(Integer pid);

    int insert(TPermision record);

    int insertSelective(TPermision record);

    List<TPermision> selectByExample(TPermision example);

    TPermision selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") TPermision record, @Param("example") TPermision example);

    int updateByExample(@Param("record") TPermision record, @Param("example") TPermision example);

    int updateByPrimaryKeySelective(TPermision record);

    int updateByPrimaryKey(TPermision record);
}