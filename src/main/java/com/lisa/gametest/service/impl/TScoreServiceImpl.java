package com.lisa.gametest.service.impl;



import com.github.pagehelper.PageHelper;
import com.lisa.gametest.dao.TScoreMapper;
import com.lisa.gametest.service.ITScoreService;

import com.lisa.gametest.vo.voScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TScoreServiceImpl implements ITScoreService {

    @Autowired(required = false)
    private TScoreMapper tScoreMapper;

    @Override
    public List<voScore> findAllScore(String typeName, String name, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<voScore> list = tScoreMapper.findAllScore(typeName, name);
        return list;
    }

    @Override
    public void deleteById(Integer sid) {
        tScoreMapper.deleteById(sid);
    }

    @Override
    public List<voScore> findAllTypeName(String typeName) {
        List<voScore> list = tScoreMapper.findAllTypeName(typeName);
        return list;
    }

    @Override
    public List<voScore> findByTypeNameSUM(String typeName) {
        List<voScore> list = tScoreMapper.findByTypeNameSUM(typeName);
        return list;
    }

    @Override
    public Integer deleteAll(int[] sidArr) {
        return tScoreMapper.deleteAll(sidArr);
    }
}
