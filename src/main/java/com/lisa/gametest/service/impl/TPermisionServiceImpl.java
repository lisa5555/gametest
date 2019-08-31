package com.lisa.gametest.service.impl;



import com.lisa.gametest.dao.TPermisionMapper;
import com.lisa.gametest.entity.TPermision;
import com.lisa.gametest.service.ITPermisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TPermisionServiceImpl implements ITPermisionService
{
    @Autowired(required = false)
    private TPermisionMapper tPermisionMapper;
    @Override
    public List<TPermision> findpermisionByName(Integer uid) {
        List<TPermision> list = tPermisionMapper.findpermisionByName(uid);
        return list;
    }
}
