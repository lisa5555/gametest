package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TRole;

import com.lisa.gametest.entity.TUserRole;
import com.lisa.gametest.vo.RoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRoleMapper {
    // 通过用户名获取角色信息
    public TRole findByName(String name);
    // 通过Id 获取对应的角色信息(即名字)
    public TRole findById(Integer id);
    // 获取所有角色信息的list集合
    public List<TRole> findAll();
    // 分页获取角色信息
    public List<TRole> findAllByLimit();

    public List<RoleInfo> findAllRoleByLimit(Integer page,Integer limit,Integer rid);
    // 添加角色信息
    public void addRole(TRole tRole);
    // 添加
    public void addUserRole(int uid);
    // 通过id修改角色信息
    public TRole queryById(Integer id);
    // 修改角色信息
    public void updateUserRole(TUserRole tUserRole);
    // 删除指定id的角色
    public void deleteById(Integer id);
}