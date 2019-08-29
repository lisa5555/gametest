package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TRolePermision;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRolePermisionMapper {
    int countByExample(TRolePermision example);

    int deleteByExample(TRolePermision example);

    int deleteByPrimaryKey(Integer tRolePermisionId);

    int insert(TRolePermision record);

    int insertSelective(TRolePermision record);

    List<TRolePermision> selectByExample(TRolePermision example);

    TRolePermision selectByPrimaryKey(Integer tRolePermisionId);

    int updateByExampleSelective(@Param("record") TRolePermision record, @Param("example") TRolePermision example);

    int updateByExample(@Param("record") TRolePermision record, @Param("example") TRolePermision example);

    int updateByPrimaryKeySelective(TRolePermision record);

    int updateByPrimaryKey(TRolePermision record);
}