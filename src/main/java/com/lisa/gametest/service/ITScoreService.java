package com.lisa.gametest.service;


import com.lisa.gametest.vo.voScore;

import java.util.List;


public interface ITScoreService {

    public List<voScore> findAllScore(String typeName, String name, Integer page, Integer limit);

    public void deleteById(Integer sid);

    /***
     * 平均分
     * @param typeName
     * @return
     */
    public List<voScore> findAllTypeName(String typeName);

    /**
     * 总分
     * @param typeName
     * @return
     */
    public List<voScore> findByTypeNameSUM(String typeName);

    public Integer deleteAll(int[] sidArr);
}
