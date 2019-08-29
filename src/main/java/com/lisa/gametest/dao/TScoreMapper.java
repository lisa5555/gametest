package com.lisa.gametest.dao;


import com.lisa.gametest.entity.TScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TScoreMapper {
    int countByExample(TScore example);

    int deleteByExample(TScore example);

    int deleteByPrimaryKey(Integer sid);

    int insert(TScore record);

    int insertSelective(TScore record);

    List<TScore> selectByExample(TScore example);

    TScore selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") TScore record, @Param("example") TScore example);

    int updateByExample(@Param("record") TScore record, @Param("example") TScore example);

    int updateByPrimaryKeySelective(TScore record);

    int updateByPrimaryKey(TScore record);
}