package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TUser;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserMapper {
    public TUser findByName(String name);

    // 根据登陆用户的用户名获取用户角色信息
    public List<String> findRolesByName(String name);

    // 根据登陆用户的用户名获取权限信息
    public List<String> findPermsByName(String name);

    int countByExample(TUser example);

    int deleteByExample(TUser example);

    int deleteByPrimaryKey(Integer uid);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUser example);

    TUser selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUser example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUser example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}