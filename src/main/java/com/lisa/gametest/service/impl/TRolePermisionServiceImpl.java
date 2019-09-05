package com.lisa.gametest.service.impl;



import com.github.pagehelper.PageHelper;
import com.lisa.gametest.dao.TRolePermisionMapper;
import com.lisa.gametest.entity.TRolePermision;
import com.lisa.gametest.service.ITRolePermisionService;
import com.lisa.gametest.vo.PersionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TRolePermisionServiceImpl implements ITRolePermisionService
{

    @Autowired(required = false)
    private TRolePermisionMapper roleMapper;

    @Override
    public List<PersionInfo> findPersionById(Integer rid) {
        List<PersionInfo> allRoleByLimit = roleMapper.findPersionById(rid);
        return allRoleByLimit;
    }

    @Override
    public void deleteById(Integer rid, Integer pid) {
        roleMapper.deleteById(rid, pid);
    }

    @Override
    public void add(Integer rid, Integer pid) {
        roleMapper.add(rid,pid);
    }
}
