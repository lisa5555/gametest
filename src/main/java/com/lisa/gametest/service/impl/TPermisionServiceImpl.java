package com.lisa.gametest.service.impl;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.dao.TPermisionMapper;
import com.lisa.gametest.entity.TPermision;
import com.lisa.gametest.service.ITPermisionService;
import com.lisa.gametest.vo.MyChoose;
import com.lisa.gametest.vo.MyPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TPermisionServiceImpl implements ITPermisionService
{
    @Autowired(required = false)
    private TPermisionMapper tPermisionMapper;
    @Override
    public List<TPermision> findpermisionByName(Integer uid) {
        List<TPermision> list = tPermisionMapper.findpermisionByName(uid);
        return list;
    }

    @Override
    public List<TPermision> findAll() {
        return tPermisionMapper.findAllPermision();
    }

    @Override
    public TPermision findTPermision(Integer pid) {
        return tPermisionMapper.findTPermision(pid);
    }

    @Override
    public Map<String, Object> findMyPermission(Integer page, Integer limit, Integer pid, String searchName) {
        PageHelper.startPage(page,limit);
        List<MyPermission> list = tPermisionMapper.findMyPermission(pid,searchName);

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

    @Override
    public Map<String, Object> findFirstTPermision(Integer page, Integer limit,String searchName) {
        PageHelper.startPage(page,limit);
        List<TPermision> list = tPermisionMapper.findFirstTPermision(searchName);

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

    @Override
    public Map<String, Object> findSecondTPermision(Integer page, Integer limit,Integer pid, String searchName) {

        List<TPermision> list = tPermisionMapper.findSecondTPermision(pid, searchName);

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

    @Override
    public int insertTPermision(TPermision tPermision) {
        return tPermisionMapper.insertTPermision(tPermision);
    }

    @Override
    public int updateTPermision(TPermision tPermision) {
        return tPermisionMapper.updateTPermision(tPermision);
    }

    @Override
    public int deleteTPermisionById(Integer pid) {
        return tPermisionMapper.deleteTPermisionById(pid);
    }

    @Override
    public int deleteTPermisionByIds(String[] ids) {
        return tPermisionMapper.deleteTPermisionByIds(ids);
    }
}
