package com.lisa.gametest.service.impl;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.dao.TChooseMapper;
import com.lisa.gametest.entity.TChoose;
import com.lisa.gametest.entity.TJudge;
import com.lisa.gametest.service.ITChooseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TChooseServiceImpl implements ITChooseService
{
    @Autowired(required = false)
    private TChooseMapper tChooseMapper;

    @Override
    public int deleteByTChooseId(Integer cid) {
        return tChooseMapper.deleteByTChooseId(cid);
    }

    @Override
    public int deleteTChooseByIds(String[] array) {
        return deleteTChooseByIds(array);
    }

    @Override
    public int insert(TChoose tChoose) {
        return tChooseMapper.insert(tChoose);
    }

    @Override
    public int insertSomeChoose(List<TChoose> list) {
        return tChooseMapper.insertSomeChoose(list);
    }

    @Override
    public int updateTChoose(TChoose tChoose) {
        return tChooseMapper.updateTChoose(tChoose);
    }

    @Override
    public TChoose selectTChooseById(Integer cid) {
        return tChooseMapper.selectTChooseById(cid);
    }

    @Override
    public Map<String, Object> selectBySearch(Integer page, Integer limit, Integer tid, String searchName, Integer score) {
        PageHelper.startPage(page,limit);
        List<TChoose> list = tChooseMapper.selectBySearch(tid,searchName,score);

        // 获取总记录数
        long total = ((Page) list).getTotal();
        // 获取总页数
        int pages = ((Page) list).getPages();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

}
