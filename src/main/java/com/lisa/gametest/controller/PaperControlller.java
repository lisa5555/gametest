package com.lisa.gametest.controller;

import com.lisa.gametest.OverPaperVo.QuestionJosn;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.service.ITPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/paper")
@CrossOrigin
public class PaperControlller {
    @Autowired
    private ITPaperService paperService;
    @RequestMapping("/query.do")
    public AjaxResult findPaperById(){
        AjaxResult result = new AjaxResult();
        try {
            List<QuestionJosn> list = paperService.showquestions(1);
            result.setCode(1);
            result.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());
        }
        return result;
    }

}
