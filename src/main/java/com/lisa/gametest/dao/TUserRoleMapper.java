package com.lisa.gametest.dao;


import com.lisa.gametest.entity.TUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserRoleMapper {
    int countByExample(TUserRole example);

    int deleteByExample(TUserRole example);

    int deleteByPrimaryKey(Integer userRoleUid);

    int insert(TUserRole record);

    int insertSelective(TUserRole record);

    List<TUserRole> selectByExample(TUserRole example);

    TUserRole selectByPrimaryKey(Integer userRoleUid);

    int updateByExampleSelective(@Param("record") TUserRole record, @Param("example") TUserRole example);

    int updateByExample(@Param("record") TUserRole record, @Param("example") TUserRole example);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);
}