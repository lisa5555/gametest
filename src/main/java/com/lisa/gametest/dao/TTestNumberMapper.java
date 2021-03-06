package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TTestNumber;

import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.vo.KsnInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTestNumberMapper {
    public List<KsnInfo> findAll(@Param("typeName") String typeName
                                );
    public List<KsnInfo> findAll2(@Param("userName")String userName,@Param("typeName") String typeName);
    public List<KsnInfo> findAll3(@Param("userName")String userName,@Param("typeName") String typeName);
    public void deleteById(int kid);
    public int findQidBKid(Integer kid);
    public void update(TTestNumber t);
    public void add(TTestNumber t);
    public List<TTestType> findName();
    public TTestNumber findById(int kid);

}