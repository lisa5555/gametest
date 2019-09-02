package com.lisa.gametest.service.impl;



import com.lisa.gametest.dao.TTestNumberMapper;
import com.lisa.gametest.entity.TTestNumber;
import com.lisa.gametest.service.ITTestNumberService;

import com.lisa.gametest.vo.KsnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TTestNumberServiceImpl implements ITTestNumberService {

    @Autowired(required = false)
    private TTestNumberMapper tn;

    @Override
    public List<KsnInfo> findAll() {
        List<KsnInfo> list = tn.findAll();
        return list;
    }

    @Override
    public void deleteById(int id) {
        tn.deleteById(id);

    }

    @Override
    public void update(TTestNumber t) {
        tn.update(t);
    }

    @Override
    public void add(TTestNumber t) {
        tn.add(t);
    }

}
