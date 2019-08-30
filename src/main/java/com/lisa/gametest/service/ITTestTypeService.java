package com.lisa.gametest.service;


import com.lisa.gametest.entity.TTestType;

import java.util.List;


public interface ITTestTypeService {

    public int insert(TTestType tTestType);

    TTestType findByName(String typeName);
}
