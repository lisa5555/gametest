package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TJudge;

import com.lisa.gametest.vo.MyJudge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TJudgeMapper {

    int deleteByTJudgeId(Integer jid);

    int deleteTJudgeByIds(String[] arr);

    int insertTJudge(TJudge tJudge);

    int insertSomeJudge(List<TJudge> list);

    TJudge selectTJudgeById(Integer jid);


    int updateTJudge(TJudge tJudge);

    List<MyJudge> selectBySearch(@Param("tid") Integer tid, @Param("searchName") String searchName, @Param("score") Integer score);
}