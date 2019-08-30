package com.lisa.gametest.controller;

import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.service.ITTestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TTestTypeController {

    @Autowired
    private ITTestTypeService itTestTypeService;

    @RequestMapping("/addTTestType")
    @ResponseBody
    public AjaxResult addTTestType(TTestType tTestType) {
        TTestType testType = itTestTypeService.findByName(tTestType.getTypename());
        if (testType != null) {
            try {
                itTestTypeService.insert(tTestType);
            } catch (Exception e) {
                return new AjaxResult(0,"添加失败");
            }
            return new AjaxResult(1,null);
        } else {
            return new AjaxResult(0,"该课程已存在");
        }
    }


}
