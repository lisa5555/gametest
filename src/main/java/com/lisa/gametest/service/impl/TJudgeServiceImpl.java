package com.lisa.gametest.service.impl;



import com.lisa.gametest.dao.TJudgeMapper;
import com.lisa.gametest.entity.TJudge;
import com.lisa.gametest.service.ITJudgeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class TJudgeServiceImpl implements ITJudgeService {

    @Autowired(required = false)
    private TJudgeMapper tJudgeMapper;

    @Override
    public int insertSomeJudge(List<TJudge> list) {
        return tJudgeMapper.insertSomeJudge(list);
    }

    @Override
    public int deleteByTJudgeId(Integer jid) {
        return tJudgeMapper.deleteByTJudgeId(jid);
    }

    @Override
    public int deleteTJudgeByIds(String[] arr) {
        return tJudgeMapper.deleteTJudgeByIds(arr);
    }

    @Override
    public int insertTJudge(TJudge tJudge) {
        return tJudgeMapper.insertTJudge(tJudge);
    }

    @Override
    public TJudge selectTJudgeById(Integer jid) {
        return tJudgeMapper.selectTJudgeById(jid);
    }

    @Override
    public List<TJudge> selectByTid(Integer tid) {
        return tJudgeMapper.selectByTid(tid);
    }

    @Override
    public int updateTJudge(TJudge tJudge) {
        return tJudgeMapper.updateTJudge(tJudge);
    }
}
