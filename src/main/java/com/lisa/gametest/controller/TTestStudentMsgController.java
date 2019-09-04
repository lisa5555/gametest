package com.lisa.gametest.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.service.ITKuinfoService;
import com.lisa.gametest.vo.Studentinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/studentmsg")
public class TTestStudentMsgController {
    @Autowired
    private ITKuinfoService ku;

    @RequestMapping("/list.do")
    public Map<String,Object> show(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Studentinfo> list = ku.findAll();
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/delete.do")
    public AjaxResult deleteById(Integer kinfoid){
        AjaxResult result = new AjaxResult();
        try {
            ku.deleteById(kinfoid);
            result.setCode(0);
            result.setInfo(null);
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setInfo(e.getMessage());
        }
        return result;
    }
}
