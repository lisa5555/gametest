package com.lisa.gametest.service.impl;



import com.lisa.gametest.dao.TTestTypeMapper;
import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.service.ITTestTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TTestTypeServiceImpl implements ITTestTypeService {

    @Autowired(required = false)
    private TTestTypeMapper tTestTypeMapper;

    @Override
    public int insert(TTestType tTestType) {
        return tTestTypeMapper.insert(tTestType);
    }

    @Override
    public TTestType findByName(String typeName) {
        return tTestTypeMapper.findByName(typeName);
    }
}
