package com.lisa.gametest.service.impl;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.common.ChangeListToArray;
import com.lisa.gametest.dao.TAnswerMapper;
import com.lisa.gametest.entity.TAnswer;
import com.lisa.gametest.entity.TJudge;
import com.lisa.gametest.service.ITAnswerService;
import com.lisa.gametest.vo.MyAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TAnswerServiceImpl implements ITAnswerService {

    @Autowired(required = false)
    private TAnswerMapper tAnswerMapper;

    @Override
    public int deleteByTAnswerId(Integer aid) {
        return tAnswerMapper.deleteByTAnswerId(aid);
    }

    @Override
    public int deleteTAnswerByIds(String[] arr) {
        return tAnswerMapper.deleteTAnswerByIds(arr);
    }

    @Override
    public int insert(TAnswer tAnswer) {
        return tAnswerMapper.insert(tAnswer);
    }

    @Override
    public int insertSomeAnswer(List<TAnswer> list) {
        return tAnswerMapper.insertSomeAnswer(list);
    }

    @Override
    public TAnswer selectTAnswerById(Integer aid) {
        return tAnswerMapper.selectTAnswerById(aid);
    }

    @Override
    public int updateTAnswer(TAnswer tAnswer) {
        return tAnswerMapper.updateTAnswer(tAnswer);
    }

    @Override
    public String createTAnswerExams(Integer tid, Integer aNum) {
        List<Integer> list = tAnswerMapper.createTAnswerExams(tid, aNum);
        return ChangeListToArray.create(list);
    }

    @Override
    public Map<String, Object> selectBySearch(Integer page, Integer limit, Integer tid, String searchName, Integer score) {
        PageHelper.startPage(page,limit);
        List<MyAnswer> list = tAnswerMapper.selectBySearch(tid,searchName,score);

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
