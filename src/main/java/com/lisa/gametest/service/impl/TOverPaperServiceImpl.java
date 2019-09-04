package com.lisa.gametest.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.dao.TOverPaperMapper;
import com.lisa.gametest.entity.TOverPaper;
import com.lisa.gametest.service.ITOverPaperService;

import com.lisa.gametest.vo.overPaperInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TOverPaperServiceImpl implements ITOverPaperService {

    @Autowired(required = false)
    private TOverPaperMapper tOverPaperMapper;

    @Override
    public List<overPaperInfo> findAllTOverPaper(String typeName,String name,Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<overPaperInfo> list = tOverPaperMapper.findAllTP(typeName,name);
        return list;
    }

    @Override
    public List<overPaperInfo> findByState(Integer oid) {
        List<overPaperInfo> list = tOverPaperMapper.findByState(oid);
        return list;
    }

    @Override
    public void deleteById(Integer oid) {
        tOverPaperMapper.deleteById(oid);
    }

    @Override
    public Integer deleteAll(int[] oidArr) {
        return tOverPaperMapper.deleteAll(oidArr);
    }


//    @Override
//    public List<TOverPaper> findAllTOverPaper() {
//        return tOverPaperMapper.findAllTOverPaper();
//    }

}
