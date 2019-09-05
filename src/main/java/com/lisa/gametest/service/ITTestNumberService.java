package com.lisa.gametest.service;


import com.lisa.gametest.entity.TTestNumber;
import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.vo.KsnInfo;


import java.util.List;


public interface ITTestNumberService {
    public List<KsnInfo> findAll(
                                 String typeName
                                 );
    public List<KsnInfo> findAll2(String username,String typeName);
    public List<KsnInfo> findAll3(String username,String typeName);
    public void deleteById(Integer kid);
    public void update(TTestNumber t);
    public void add(TTestNumber t);
    public List<TTestType> findName();
    public TTestNumber findById(Integer kid);
    public int findQidBKid(Integer kid);
}
