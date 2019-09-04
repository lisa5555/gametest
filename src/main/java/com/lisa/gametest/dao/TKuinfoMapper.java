package com.lisa.gametest.dao;

import com.lisa.gametest.vo.Studentinfo;
import java.util.List;

public interface TKuinfoMapper {
    public List<Studentinfo> findAll();
    public void deleteById (Integer kinfoid);
}