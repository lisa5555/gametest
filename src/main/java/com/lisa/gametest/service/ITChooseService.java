package com.lisa.gametest.service;


import com.lisa.gametest.entity.TChoose;

import java.util.List;
import java.util.Map;


public interface ITChooseService {

    public int deleteByTChooseId(Integer cid);

    public int deleteTChooseByIds(String[] array);

    public int insert(TChoose tChoose);

    public int insertSomeChoose(List<TChoose> list);

    public int updateTChoose(TChoose tChoose);


    public TChoose selectTChooseById(Integer cid);

    public  int findTChooseCount(Integer tid);


    public String createTChooseExams(Integer tid, Integer cNum);

    public Map<String,Object> selectBySearch(Integer page, Integer limit,Integer tid, String searchName, Integer score);

}
