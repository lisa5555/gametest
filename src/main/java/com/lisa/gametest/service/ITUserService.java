package com.lisa.gametest.service;


import com.lisa.gametest.entity.TUser;

import java.util.List;

public interface ITUserService {
    public TUser findByName(String name);
    public List<TUser> findAll();
    public List<TUser> findAllByLimit(Integer page, Integer limit);
    public void add(TUser tUser);
    public TUser queryById(Integer id);
    public void update(TUser tUser);
    public void deleteById(Integer id);
    public TUser login(String userName,String password);
}
