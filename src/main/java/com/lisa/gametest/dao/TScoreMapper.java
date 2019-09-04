package com.lisa.gametest.dao;


import com.lisa.gametest.vo.voScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TScoreMapper {

    public List<voScore> findAllScore(@Param("typeName") String typeName,
                                      @Param("name") String name);

    public void deleteById(Integer sid);

    public List<voScore> findAllTypeName(String typeName);

    public Integer deleteAll(int[] sidArr);

}