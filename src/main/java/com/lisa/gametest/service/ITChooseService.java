package com.lisa.gametest.service;


import com.lisa.gametest.entity.TChoose;

import java.util.List;


public interface ITChooseService {

    public int deleteByTChooseId(Integer cid);

    public int deleteTChooseByIds(String[] array);

    public int insert(TChoose tChoose);

    public int insertSomeChoose(List<TChoose> list);

    public int updateTChoose(TChoose tChoose);

    public List<TChoose> selectByTid(Integer tid);

    public TChoose selectTChooseById(Integer cid);
}
