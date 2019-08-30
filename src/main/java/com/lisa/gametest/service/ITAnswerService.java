package com.lisa.gametest.service;


import com.lisa.gametest.entity.TAnswer;

import java.util.List;

public interface ITAnswerService {

     public int deleteByTAnswerId(Integer aid);

     public int deleteTAnswerByIds(String[] arr);

     public int insert(TAnswer tAnswer);

     public int insertSomeAnswer(List<TAnswer> list);

     public TAnswer selectTAnswerById(Integer aid);

     public List<TAnswer> selectByTid(Integer tid);

     public int updateTAnswer(TAnswer tAnswer);

}
