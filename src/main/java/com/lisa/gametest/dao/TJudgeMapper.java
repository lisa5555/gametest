package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TJudge;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TJudgeMapper {
    int countByExample(TJudge example);

    int deleteByExample(TJudge example);

    int deleteByPrimaryKey(Integer jid);

    int insert(TJudge record);

    int insertSelective(TJudge record);

    List<TJudge> selectByExample(TJudge example);

    TJudge selectByPrimaryKey(Integer jid);

    int updateByExampleSelective(@Param("record") TJudge record, @Param("example") TJudge example);

    int updateByExample(@Param("record") TJudge record, @Param("example") TJudge example);

    int updateByPrimaryKeySelective(TJudge record);

    int updateByPrimaryKey(TJudge record);
}