package com.lisa.gametest.service;


import com.lisa.gametest.entity.TAnswer;

import java.util.List;
import java.util.Map;

public interface ITAnswerService {

     public int deleteByTAnswerId(Integer aid);

     public int deleteTAnswerByIds(String[] arr);

     public int insert(TAnswer tAnswer);

     public int insertSomeAnswer(List<TAnswer> list);

     public TAnswer selectTAnswerById(Integer aid);

     public int updateTAnswer(TAnswer tAnswer);

     public String createTAnswerExams(Integer tid, Integer aNum);

     public Map<String,Object> selectBySearch(Integer page, Integer limit,Integer tid, String searchName, Integer score);


}
