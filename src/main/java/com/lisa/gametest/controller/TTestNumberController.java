package com.lisa.gametest.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TTestNumber;
import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.service.ITTestNumberService;
import com.lisa.gametest.vo.KsnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/number")
public class TTestNumberController {
    @Autowired
    private ITTestNumberService ns;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @RequestMapping("/list.do")
    public Map<String,Object>  show(Integer page,Integer limit,String typeName) {
        PageHelper.startPage(page,limit);
        List<KsnInfo> list = ns.findAll(typeName);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }
@RequestMapping("/delete.do")
public AjaxResult deleteById(Integer kid){
        AjaxResult result = new AjaxResult();
        try {
            ns.deleteById(kid);
            result.setCode(0);
            result.setInfo(null);
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setInfo(e.getMessage());
        }
        return result;
}

@RequestMapping("/add.do")
public AjaxResult add(TTestNumber t) {
        AjaxResult result = new AjaxResult();
        try {
            ns.add(t);
            result.setCode(0);
            result.setInfo(null);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(1);
            result.setInfo(e.getMessage());
        }
        return result;
}

@RequestMapping("/update.do")
public AjaxResult update(TTestNumber t, HttpServletRequest request){
    String id = request.getParameter("id");
    AjaxResult jsonResult = new AjaxResult();
    try {
        ns.update(t);
        jsonResult.setCode(0);
        jsonResult.setInfo(null);
    } catch (Exception e) {
        e.printStackTrace();
        jsonResult.setCode(1);
        jsonResult.setInfo(e.getMessage());
    }
    return jsonResult;
}

    @RequestMapping("/query.do")
    public AjaxResult findName(){
        AjaxResult result = new AjaxResult();
        try {
            List<TTestType> list = ns.findName();
            result.setCode(0);
            result.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setInfo(null);
        }
        return result;
    }


    @RequestMapping("/queryById.do")
    public AjaxResult findById(Integer kid){
        AjaxResult result = new AjaxResult();
        try {
            TTestNumber byId = ns.findById(kid);
            result.setCode(0);
            result.setInfo(byId);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(1);
            result.setInfo(null);
        }

        return result;
    }
}
