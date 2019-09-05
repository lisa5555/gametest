package com.lisa.gametest.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.lisa.gametest.dao.TRoleMapper;
import com.lisa.gametest.entity.TRole;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.entity.TUserRole;
import com.lisa.gametest.service.ITRoleService;

import com.lisa.gametest.vo.RoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TRoleServiceImpl implements ITRoleService {

    @Autowired(required = false)
    private TRoleMapper roleMapper;

    @Override
    public TRole findByName(String name) {
        TRole t = roleMapper.findByName(name);
        return t;
    }

    @Override
    public TRole findById(Integer id) {
        TRole role = roleMapper.findById(id);
        return role;
    }

    @Override
    public List<TRole> findAll() {
        List<TRole> roleList = roleMapper.findAll();
        return roleList;
    }

    @Override
    public List<TRole> findAllByLimit(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TRole> allLimit = roleMapper.findAllByLimit();
        return allLimit;

    }

    @Override
    public List<RoleInfo> findAllRoleByLimit(Integer page, Integer limit, Integer rid) {
        PageHelper.startPage(page, limit);
        List<RoleInfo> allLimit = roleMapper.findAllRoleByLimit(page, limit, rid);
        return allLimit;
    }

    @Override
    public void addRole(TRole tRole) {
        roleMapper.addRole(tRole);
    }

    @Override
    public void addUserRole(int id) {
        roleMapper.addUserRole(id);
    }


    @Override
    public TRole queryById(Integer id) {
        TRole role = roleMapper.queryById(id);
        return role;
    }

    @Override
    public void updateUserRole(TUserRole tUserRole) {
        roleMapper.updateUserRole(tUserRole);
    }

    @Override
    public void deleteById(Integer id) {
        roleMapper.deleteById(id);
    }
}
