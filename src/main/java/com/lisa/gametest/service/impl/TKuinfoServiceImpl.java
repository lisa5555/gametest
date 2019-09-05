package com.lisa.gametest.service.impl;

import java.util.List;

import com.lisa.gametest.dao.TKuinfoMapper;
import com.lisa.gametest.service.ITKuinfoService;
import com.lisa.gametest.vo.Studentinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TKuinfoServiceImpl implements ITKuinfoService {

    @Autowired(required = false)
    private TKuinfoMapper tk;

    @Override
    public List<Studentinfo> findAll(String name,String typeName) {
        return tk.findAll(name,typeName);
    }

    @Override
    public void deleteById(Integer kinfoid) {
        tk.deleteById(kinfoid);
    }
}
