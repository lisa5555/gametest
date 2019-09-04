package com.lisa.gametest.service;


import com.lisa.gametest.entity.TTestNumber;
import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.vo.KsnInfo;


import java.util.List;


public interface ITTestNumberService {
    public List<KsnInfo> findAll(
                                 String typeName
                                 );
    public void deleteById(int kid);
    public void update(TTestNumber t);
    public void add(TTestNumber t);
    public List<TTestType> findName();
}
