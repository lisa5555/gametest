package com.lisa.gametest.service.impl;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.common.ChangeListToArray;
import com.lisa.gametest.dao.TJudgeMapper;
import com.lisa.gametest.entity.TJudge;
import com.lisa.gametest.service.ITJudgeService;
import com.lisa.gametest.vo.MyJudge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TJudgeServiceImpl implements ITJudgeService {

    @Autowired(required = false)
    private TJudgeMapper tJudgeMapper;

    @Override
    public int insertSomeJudge(List<TJudge> list) {
        return tJudgeMapper.insertSomeJudge(list);
    }

    @Override
    public int deleteByTJudgeId(Integer jid) {
        return tJudgeMapper.deleteByTJudgeId(jid);
    }

    @Override
    public int deleteTJudgeByIds(String[] arr) {
        return tJudgeMapper.deleteTJudgeByIds(arr);
    }

    @Override
    public int insertTJudge(TJudge tJudge) {
        return tJudgeMapper.insertTJudge(tJudge);
    }

    @Override
    public TJudge selectTJudgeById(Integer jid) {
        return tJudgeMapper.selectTJudgeById(jid);
    }

    @Override
    public int updateTJudge(TJudge tJudge) {
        return tJudgeMapper.updateTJudge(tJudge);
    }

    @Override
    public String createTJudgeExams(Integer tid, Integer jNum) {
        List<Integer> list = tJudgeMapper.createTJudgeExams(tid, jNum);
        return ChangeListToArray.create(list);
    }

    @Override
    public Map<String, Object> selectBySearch(Integer page, Integer limit, Integer tid, String searchName, Integer score) {
        PageHelper.startPage(page,limit);
        List<MyJudge> list = tJudgeMapper.selectBySearch(tid,searchName,score);

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
