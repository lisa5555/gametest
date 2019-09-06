package com.lisa.gametest.service.impl;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.common.ChangeListToArray;
import com.lisa.gametest.dao.TChooseMapper;
import com.lisa.gametest.entity.TChoose;
import com.lisa.gametest.entity.TJudge;
import com.lisa.gametest.service.ITChooseService;

import com.lisa.gametest.vo.MyChoose;
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
    public List<TChoose> findTChooseByPid(Integer pid) {
        return tChooseMapper.findTChooseByPid(pid);
    }

    @Override
    public int deleteByTChooseId(Integer cid) {
        return tChooseMapper.deleteByTChooseId(cid);
    }

    @Override
    public int deleteTChooseByIds(String[] array) {
        return tChooseMapper.deleteTChooseByIds(array);
    }

    @Override
    public int insert(TChoose tChoose) {
        return tChooseMapper.insertTChoose(tChoose);
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
    public List<TChoose> findTenTChoose() {
        return tChooseMapper.findTenTChoose();
    }

    @Override
    public TChoose selectTChooseById(Integer cid) {
        return tChooseMapper.selectTChooseById(cid);
    }

    @Override
    public int findTChooseCount(Integer tid) {
        return tChooseMapper.findTChooseCount(tid);
    }

    @Override
    public String createTChooseExams(Integer tid, Integer cNum) {
        List<Integer> list = tChooseMapper.createTChooseExams(tid, cNum);
        return ChangeListToArray.create(list);
    }

    @Override
    public Map<String, Object> selectBySearch(Integer page, Integer limit, Integer tid, String searchName, Integer score) {
        PageHelper.startPage(page,limit);
        List<MyChoose> list = tChooseMapper.selectBySearch(tid,searchName,score);

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
