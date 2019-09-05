package com.lisa.gametest.service.impl;

import com.github.pagehelper.PageHelper;
import com.lisa.gametest.dao.TUserMapper;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TUserServiceImpl implements ITUserService
{
    @Autowired(required = false)
    private TUserMapper user;
    @Override
    public TUser findByName(String name) {
        TUser us = user.findByName(name);
        return us;
    }

    @Override
    public List<TUser> findAll() {
        List<TUser> userAll = user.findAll();
        return userAll;
    }

    @Override
    public List<TUser> findAll1(Integer page, Integer limit, String username, String name, String sex) {
        PageHelper.startPage(page, limit);
        List<TUser> all = user.findAll1(page, limit, username, name, sex);
        return all;
    }

    @Override
    public List<TUser> findAllByLimit(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TUser> userAllByLimit = user.findAllByLimit();
        return userAllByLimit;
    }

    @Override
    public List<TUserInfo> findAllByLimit2(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TUserInfo> userAllByLimit = user.findAllByLimit2();
        return userAllByLimit;
    }

    @Override
    public void add(TUser tUser) {
        user.add(tUser);
    }

    @Override
    public TUser queryById(Integer id) {
        TUser tUser = user.queryById(id);
        return tUser;
    }

    @Override
    public void update(TUser tUser) {
        user.update(tUser);
    }

    @Override
    public void deleteById(Integer id) {
        user.deleteById(id);
    }

    @Override
    public void checkById(Integer id) {
        user.checkById(id);
    }

    @Override
    public TUser login(String userName, String password) {
        TUser userByName = user.findByName(userName);
        if (userByName==null){
           throw new RuntimeException("用户名不存在");
        }
        if (!userByName.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }


        return userByName;
    }
}
