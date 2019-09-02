package com.lisa.gametest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisa.gametest.OverPaperVo.PaperAnswerInfo;
import com.lisa.gametest.common.AjaxResult;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/overpaper")
public class TOverPaperController {
    @RequestMapping("/over.do")
    public AjaxResult commiitPaper(String info){
        System.out.println(info);
        ObjectMapper mapper = new ObjectMapper();
        List<PaperAnswerInfo> lendReco = null;
        try {
            lendReco = mapper.readValue(info,new TypeReference<List<PaperAnswerInfo>>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lendReco.size());
        return new AjaxResult(1,null);
    }
}
