package com.lisa.gametest.service;


import com.lisa.gametest.vo.voScore;

import java.util.List;


public interface ITScoreService {

    public List<voScore> findAllScore(String typeName, String name, Integer page, Integer limit);

    public void deleteById(Integer sid);

    public List<voScore> findAllTypeName(String typeName);

    public Integer deleteAll(int[] sidArr);
}
