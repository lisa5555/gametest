package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TTestNumber;

import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.vo.KsnInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTestNumberMapper {
    public List<KsnInfo> findAll(@Param("typeName") String typeName
                                );
    public void deleteById(int kid);
    public void update(TTestNumber t);
    public void add(TTestNumber t);
    public List<TTestType> findName();
}