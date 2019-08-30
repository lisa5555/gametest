package com.lisa.gametest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.common.ExcelUtils;
import com.lisa.gametest.entity.TChoose;
import com.lisa.gametest.entity.TJudge;
import com.lisa.gametest.service.ITJudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Map;

@Controller
public class TJudgeController {

    @Autowired(required = false)
    private ITJudgeService itJudgeService;

    @RequestMapping("/addTjudge")
    @ResponseBody
    public AjaxResult addJudge(TJudge tJudge){
        try {
            itJudgeService.insert(tJudge);
        }catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"添加失败");
        }
        return new AjaxResult(1,null);
    }

    /**
     * 批量导入判断题
     * @param upfile
     * @return
     */
    @RequestMapping("/importTjudge")
    @ResponseBody
    public AjaxResult importExcel(@RequestParam MultipartFile upfile){

        // 获取上传文件的输入流对象
        try {
            List<Map<String, Object>> list = ExcelUtils.readExcel(upfile);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(list);
            // 将json格式的字符串转为指定类型的对象
            List<TJudge> tJudgeList = objectMapper.readValue(jsonStr, new TypeReference<List<TJudge>>() {});

            itJudgeService.insertSomeJudge(tJudgeList);

        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"导入失败");
        }

        return new AjaxResult(1,null);
    }


}
