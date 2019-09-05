package com.lisa.gametest.service.impl;



import com.github.pagehelper.PageHelper;
import com.lisa.gametest.dao.TTestNumberMapper;
import com.lisa.gametest.entity.TTestNumber;
import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.service.ITTestNumberService;

import com.lisa.gametest.vo.KsnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TTestNumberServiceImpl implements ITTestNumberService {

    @Autowired(required = false)
    private TTestNumberMapper tn;

    @Override
    public List<KsnInfo> findAll(String typeName) {
        List<KsnInfo> list = tn.findAll(typeName);
        return list;
    }

    @Override
    public List<KsnInfo> findAll2(String username,String typeName) {
        return tn.findAll2(username,typeName);
    }


    @Override
    public void deleteById(Integer kid) {
        tn.deleteById(kid);

    }

    @Override
    public void update(TTestNumber t) {
        tn.update(t);
    }

    @Override
    public void add(TTestNumber t) {
        tn.add(t);
    }

    @Override
    public List<TTestType> findName() {
        return tn.findName();
    }

    @Override
    public TTestNumber findById(Integer kid) {
        return tn.findById(kid);
    }


}

