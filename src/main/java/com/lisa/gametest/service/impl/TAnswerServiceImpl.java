package com.lisa.gametest.service.impl;



import com.lisa.gametest.dao.TAnswerMapper;
import com.lisa.gametest.entity.TAnswer;
import com.lisa.gametest.service.ITAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TAnswerServiceImpl implements ITAnswerService {

    @Autowired(required = false)
    private TAnswerMapper tAnswerMapper;

    @Override
    public int deleteByTAnswerId(Integer aid) {
        return tAnswerMapper.deleteByTAnswerId(aid);
    }

    @Override
    public int deleteTAnswerByIds(String[] arr) {
        return tAnswerMapper.deleteTAnswerByIds(arr);
    }

    @Override
    public int insert(TAnswer tAnswer) {
        return tAnswerMapper.insert(tAnswer);
    }

    @Override
    public int insertSomeAnswer(List<TAnswer> list) {
        return tAnswerMapper.insertSomeAnswer(list);
    }

    @Override
    public TAnswer selectTAnswerById(Integer aid) {
        return tAnswerMapper.selectTAnswerById(aid);
    }

    @Override
    public List<TAnswer> selectByTid(Integer tid) {
        return tAnswerMapper.selectByTid(tid);
    }

    @Override
    public int updateTAnswer(TAnswer tAnswer) {
        return tAnswerMapper.updateTAnswer(tAnswer);
    }
}
