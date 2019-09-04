package com.lisa.gametest.service.impl;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.dao.TAnswerMapper;
import com.lisa.gametest.dao.TChooseMapper;
import com.lisa.gametest.dao.TJudgeMapper;
import com.lisa.gametest.dao.TTestTypeMapper;
import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.service.ITTestTypeService;

import com.lisa.gametest.vo.MyTypeProblems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TTestTypeServiceImpl implements ITTestTypeService {

    @Autowired(required = false)
    private TTestTypeMapper tTestTypeMapper;

    @Autowired(required = false)
    private TAnswerMapper tAnswerMapper;
    @Autowired(required = false)
    private TChooseMapper tChooseMapper;
    @Autowired(required = false)
    private TJudgeMapper tJudgeMapper;

    @Override
    public List<TTestType> findAll() {
        return tTestTypeMapper.findAll();
    }

    @Override
    public int insertTTestType(String typeName) {
        return tTestTypeMapper.insertTTestType(typeName);
    }

    @Override
    public TTestType findByName(String typeName) {
        return tTestTypeMapper.findByName(typeName);
    }

    @Override
    public TTestType findById(Integer tid) {
        return tTestTypeMapper.findById(tid);
    }

    @Override
    public int deleteTTestType(Integer tid) {
        return tTestTypeMapper.deleteTTestType(tid);
    }

    @Override
    public int deleteTTestTypeByIds(String[] arr) {
        return tTestTypeMapper.deleteTTestTypeByIds(arr);
    }

    @Override
    public Map<String, Object> selectBySearch(Integer page, Integer limit, String searchName) {
        PageHelper.startPage(page,limit);
        List<TTestType> list = tTestTypeMapper.selectBySearch(searchName);

        // 获取总记录数
        long total = ((Page) list).getTotal();
        // 获取总页数
        int pages = ((Page) list).getPages();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    @Override
    public int updateTTestType(TTestType tTestType) {
        return tTestTypeMapper.updateTTestType(tTestType);
    }

    @Override
    public List<MyTypeProblems> findTypeProblem(Integer tid) {

        List<MyTypeProblems> list = new ArrayList<>();
        MyTypeProblems problems = new MyTypeProblems();
        TTestType type = tTestTypeMapper.findById(tid);
        problems.setTid(tid);
        problems.setTypeName(type.getTypeName());

        int a = tAnswerMapper.findTAnswerCount(tid);
        int c = tChooseMapper.findTChooseCount(tid);
        int j = tJudgeMapper.findTJudgeCount(tid);

        problems.setJudgeNum(j);
        problems.setChooseNum(c);
        problems.setAnswerNum(a);

        list.add(problems);
        return list;
    }
}
