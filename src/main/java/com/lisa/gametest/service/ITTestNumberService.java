package com.lisa.gametest.service;


import com.lisa.gametest.entity.TTestNumber;
import com.lisa.gametest.vo.KsnInfo;

import java.util.List;


public interface ITTestNumberService {
    public List<KsnInfo> findAll();
    public void deleteById(int id);
    public void update(TTestNumber t);
    public void add(TTestNumber t);
}
