package com.lisa.gametest.service;


import com.lisa.gametest.vo.Studentinfo;

import java.util.List;

public interface ITKuinfoService {
    public List<Studentinfo> findAll(String name,String typeName);
    public void deleteById (Integer kinfoid);
}
