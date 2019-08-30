package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TAnswer;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAnswerMapper {

    int deleteByTAnswerId(Integer aid);

    int deleteTAnswerByIds(String[] arr);

    int insert(TAnswer tAnswer);

    int insertSomeAnswer(List<TAnswer> list);

    TAnswer selectTAnswerById(Integer aid);

    List<TAnswer> selectBySearch(@Param("tid") Integer tid, @Param("searchName") String searchName, @Param("score") Integer score);

    int updateTAnswer(TAnswer tAnswer);
}