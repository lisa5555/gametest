package com.lisa.gametest.controller;

import com.github.pagehelper.Page;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TOverPaper;
import com.lisa.gametest.service.ITOverPaperService;
import com.lisa.gametest.vo.overPaperInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/overPaper")
public class overPaperController {

    @Autowired
    private ITOverPaperService itOverPaperService;

    @ResponseBody
    @RequestMapping("/query.do")
    public Map<String,Object> findAllTOverPaper(String typeName,Integer page, Integer limit) {
        List<overPaperInfo> list = itOverPaperService.findAllTOverPaper(typeName,page, limit);
        long total = ((Page) list).getTotal();

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }
}
