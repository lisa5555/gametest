package com.lisa.gametest.service;


import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.vo.TUserInfo;

import java.util.List;

public interface ITUserService {
    public TUser findByName(String name);
    public List<TUser> findAll();
    public List<TUser> findAll1(Integer page,Integer limit,String username,String name,String sex,Integer state);
    public List<TUser> findAllByLimit(Integer page, Integer limit);
    public List<TUserInfo> findAllByLimit2(Integer page, Integer limit);
    public void add(TUser tUser);
    public void checkById(Integer id);
    public TUser queryById(Integer id);
    public void update(TUser tUser);
    public void deleteById(Integer id);
    public TUser login(String userName,String password);
//
//    public int deleteTUserByIds(String[] ids);
}
