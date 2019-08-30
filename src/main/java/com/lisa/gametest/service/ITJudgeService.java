package com.lisa.gametest.service;


import com.lisa.gametest.entity.TJudge;

import java.util.List;
import java.util.Map;


public interface ITJudgeService 
{

    public int insertSomeJudge(List<TJudge> list);

    public int deleteByTJudgeId(Integer jid);

    public int deleteTJudgeByIds(String[] arr);

    public int insertTJudge(TJudge tJudge);

    public TJudge selectTJudgeById(Integer jid);

    public int updateTJudge(TJudge tJudge);

    public Map<String,Object> selectBySearch(Integer page, Integer limit, Integer tid, String searchName, Integer score);


}
