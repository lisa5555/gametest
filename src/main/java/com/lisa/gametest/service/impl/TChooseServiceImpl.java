package com.lisa.gametest.service.impl;



import com.lisa.gametest.dao.TChooseMapper;
import com.lisa.gametest.entity.TChoose;
import com.lisa.gametest.service.ITChooseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TChooseServiceImpl implements ITChooseService
{
    @Autowired(required = false)
    private TChooseMapper tChooseMapper;

    @Override
    public int deleteByTChooseId(Integer cid) {
        return tChooseMapper.deleteByTChooseId(cid);
    }

    @Override
    public int deleteTChooseByIds(String[] array) {
        return deleteTChooseByIds(array);
    }

    @Override
    public int insert(TChoose tChoose) {
        return tChooseMapper.insert(tChoose);
    }

    @Override
    public int insertSomeChoose(List<TChoose> list) {
        return tChooseMapper.insertSomeChoose(list);
    }

    @Override
    public int updateTChoose(TChoose tChoose) {
        return tChooseMapper.updateTChoose(tChoose);
    }

    @Override
    public List<TChoose> selectByTid(Integer tid) {
        return tChooseMapper.selectByTid(tid);
    }

    @Override
    public TChoose selectTChooseById(Integer cid) {
        return tChooseMapper.selectTChooseById(cid);
    }

}
