package com.lisa.gametest.service;


import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.vo.MyTypeProblems;

import java.util.List;
import java.util.Map;


public interface ITTestTypeService {

    public List<TTestType> findAll();

    public int insertTTestType(String typeName);

    public TTestType findByName(String typeName);

    public TTestType findById(Integer tid);

    public int deleteTTestType(Integer tid);

    public int deleteTTestTypeByIds(String[] arr);

    public Map<String, Object> selectBySearch(Integer page, Integer limit, String searchName);

    public int updateTTestType(TTestType tTestType);

    public List<MyTypeProblems> findTypeProblem(Integer tid);
}
