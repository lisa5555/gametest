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
@RequestMapping("/TJudge")
public class TJudgeController {

    @Autowired
    private ITJudgeService itJudgeService;

    /**
     * 添加判断题
     * @param tJudge
     * @return
     */
    @RequestMapping("/addTJudge")
    @ResponseBody
    public AjaxResult addJudge(TJudge tJudge){
        try {
            itJudgeService.insertTJudge(tJudge);
            return new AjaxResult(1,null);
        }catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"添加失败");
        }
    }

    /**
     * 批量导入判断题
     * @param upfile
     * @return
     */
    @RequestMapping("/importTJudge")
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


    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteTJudge")
    @ResponseBody
    public AjaxResult deleteTJudge(Integer id) {
        try {
            itJudgeService.deleteByTJudgeId(id);
            return new AjaxResult(1, null);
        } catch (Exception e) {
            return new AjaxResult(0,"更新失败");
        }
    }


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/deleteSomeTJudge")
    @ResponseBody
    public AjaxResult deleteSomeTJudge(String ids) {
        String[] array = ids.split(",");

        try {
            itJudgeService.deleteTJudgeByIds(array);
            return new AjaxResult(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0, "批量删除失败");
        }
    }


    /**
     * 根据id查找
     * @param id
     * @return
     */
    @RequestMapping("/findTJudge")
    @ResponseBody
    public AjaxResult queryTJudge(Integer id) {
        TJudge tJudge = itJudgeService.selectTJudgeById(id);
        return new AjaxResult(1, tJudge);
    }


    /**
     * 更新判断题
     * @param tJudge
     * @return
     */
    @RequestMapping("/updateTJudge")
    @ResponseBody
    public AjaxResult updateTJudge(TJudge tJudge) {
        try {
            itJudgeService.updateTJudge(tJudge);
            return new AjaxResult(1, null);
        } catch (Exception e) {
            return new AjaxResult(0, "更新失败");
        }
    }

    /**
     * 查找当前课程有关的多有判断题
     * @param page
     * @param limit
     * @param searchName
     * @param score
     * @param tid
     * @return
     */
    @RequestMapping("/listTJudge")
    @ResponseBody
    public Map<String, Object> listJudge(Integer page, Integer limit, String searchName, Integer score, Integer tid){
        Map<String, Object> map = itJudgeService.selectBySearch(page, limit, tid, searchName, score);
        return map;

    }

}
