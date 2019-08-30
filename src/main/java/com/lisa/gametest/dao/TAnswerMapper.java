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

    List<TAnswer> selectByTid(Integer tid);

    int updateTAnswer(TAnswer tAnswer);
}