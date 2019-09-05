package com.lisa.gametest.dao;

import com.lisa.gametest.vo.Studentinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TKuinfoMapper {
    public List<Studentinfo> findAll(@Param("name")String name,@Param("typeName") String typeName);
    public void deleteById (Integer kinfoid);
}