package com.lisa.gametest.service.impl;

import com.lisa.gametest.dao.TUserMapper;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
}
