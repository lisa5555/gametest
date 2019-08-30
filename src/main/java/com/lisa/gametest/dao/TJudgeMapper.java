package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TJudge;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TJudgeMapper {

    int deleteByTJudgeId(Integer jid);

    int deleteTJudgeByIds(String[] arr);

    int insertTJudge(TJudge tJudge);

    int insertSomeJudge(List<TJudge> list);

    TJudge selectTJudgeById(Integer jid);

    List<TJudge> selectByTid(Integer tid);

    int updateTJudge(TJudge tJudge);
}