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
    public List<TUser> findAllByLimit(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TUser> userAllByLimit = user.findAllByLimit();
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
}
