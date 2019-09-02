package com.lisa.gametest.service.impl;



import com.lisa.gametest.dao.TPaperMapper;
import com.lisa.gametest.entity.TPaper;
import com.lisa.gametest.service.ITPaperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TPaperServiceImpl implements ITPaperService
{
    @Autowired(required = false)
    private TPaperMapper paperMapper;
    @Override
    public TPaper findPaperById(Integer id) {
        TPaper paper = paperMapper.findPaperById(id);
        return paper;
    }
}
