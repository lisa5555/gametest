package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TKuinfo;
import com.lisa.gametest.vo.Studentinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TKuinfoMapper {
    public List<Studentinfo> findAll(@Param("name")String name,@Param("typeName") String typeName);

    //取消报名
    public void deleteById (Integer kinfoid);


    public int insertTKuinfo(TKuinfo tKuinfo);

}