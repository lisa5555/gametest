package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TUser;

import com.lisa.gametest.vo.TUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserMapper {
    public TUser findByName(String name);

    // 根据登陆用户的用户名获取用户角色信息
    public List<String> findRolesByName(String name);

    // 根据登陆用户的用户名获取权限信息
    public List<String> findPermsByName(String name);

    // 获取所有用户信息的list集合
    public List<TUser> findAll();

    public List<TUser> findAll1(Integer page,Integer limit,String username,String name,String sex,Integer state);
    // 分页获取用户信息
    public List<TUser> findAllByLimit();
    // 分页获取用户信息
    public List<TUserInfo> findAllByLimit2();
    // 添加用户信息
    public void add(TUser tUser);
    // 通过id修改用户信息
    public TUser queryById(Integer id);
    // 修改用户信息
    public void update(TUser tUser);
    // 删除指定id的用户
    public void deleteById(Integer id);

    public void checkById(Integer id);
//
//    public int deleteTUserByIds(String[] ids);
}