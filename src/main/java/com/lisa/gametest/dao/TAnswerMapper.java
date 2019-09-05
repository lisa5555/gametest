package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TAnswer;

import com.lisa.gametest.vo.MyAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAnswerMapper {

    List<TAnswer> findTTAnswerByPid(Integer qid);

    int deleteByTAnswerId(Integer aid);

    int deleteTAnswerByIds(String[] aid);

    int insert(TAnswer tAnswer);

    int insertSomeAnswer(List<TAnswer> list);

    int findTAnswerCount(Integer tid);

    List<Integer> createTAnswerExams(@Param("tid") Integer tid, @Param("aNum") Integer aNum);

    TAnswer selectTAnswerById(Integer aid);

    List<MyAnswer> selectBySearch(@Param("tid") Integer tid, @Param("searchName") String searchName, @Param("score") Integer score);

    int updateTAnswer(TAnswer tAnswer);
}