package com.lisa.gametest.controller;

import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TTestNumber;
import com.lisa.gametest.service.ITTestNumberService;
import com.lisa.gametest.vo.KsnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/number")
public class TTestNumberController {
    @Autowired
    private ITTestNumberService ns;

    @RequestMapping("/list.do")
    public AjaxResult show() {
        AjaxResult result = new AjaxResult();
        try {
            List<KsnInfo> list = ns.findAll();
            result.setCode(1);
            result.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());
        }
        return result;
    }
@RequestMapping("delete.do")
public AjaxResult deleteById(Integer id){
        AjaxResult result = new AjaxResult();
        try {
            ns.deleteById(id);
            result.setCode(0);
            result.setInfo(null);
        }catch (Exception e) {
            e.printStackTrace();
            result.setInfo(1);
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

@RequestMapping("update.do")
public AjaxResult update(TTestNumber t, HttpServletRequest request){
    String id = request.getParameter("id");
    AjaxResult jsonResult = new AjaxResult();
    try {
        t.setKid(Integer.parseInt(id));
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
}
