package com.lisa.gametest.service;


import com.lisa.gametest.entity.TJudge;

import java.util.List;


public interface ITJudgeService 
{

    public int insertSomeJudge(List<TJudge> list);

    public int deleteByTJudgeId(Integer jid);

    public int deleteTJudgeByIds(String[] arr);

    public int insertTJudge(TJudge tJudge);

    public TJudge selectTJudgeById(Integer jid);

    public List<TJudge> selectByTid(Integer tid);

    public int updateTJudge(TJudge tJudge);

}
