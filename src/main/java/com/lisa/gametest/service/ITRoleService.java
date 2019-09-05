package com.lisa.gametest.service;


import com.lisa.gametest.entity.TRole;
import com.lisa.gametest.entity.TUserRole;
import com.lisa.gametest.vo.RoleInfo;


import java.util.List;

public interface ITRoleService {
    public TRole findByName(String name);
    public TRole findById(Integer id);
    public List<TRole> findAll();
    public List<TRole> findAllByLimit(Integer page, Integer limit);
    public List<RoleInfo> findAllRoleByLimit(Integer page, Integer limit, Integer rid);
    public void addRole(TRole tRole);
    public void addUserRole(int id);
    public TRole queryById(Integer id);
    public void updateUserRole(TUserRole tUserRole);
    public void deleteById(Integer id);
}
