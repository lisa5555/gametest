package com.lisa.gametest.controller;

import com.lisa.gametest.OverPaperVo.QuestionJosn;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TPaper;
import com.lisa.gametest.service.*;
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
public class PaperController {
    @Autowired
    private ITPaperService paperService;

    @Autowired
    private ITChooseService itChooseService;

    @Autowired
    private ITAnswerService itAnswerService;

    @Autowired
    private ITJudgeService itJudgeService;
    @Autowired
    private ITTestNumberService service;

    @RequestMapping("/query.do")
    public AjaxResult findPaperById(Integer kid){
        AjaxResult result = new AjaxResult();
        try {
            int qid = service.findQidBKid(kid);
            List<QuestionJosn> list = paperService.showquestions(qid);
            result.setCode(1);
            result.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());
        }
        return result;
    }


    /**
     * 随机为tid的课程生成试题
     * @param tid
     * @param cNum 选择题数量
     * @param jNum  判断题数量
     * @param aNum   简答题数量
     * @return
     */
    @RequestMapping("/createExamination")
    @ResponseBody
    public AjaxResult createExamination(Integer tid, Integer cNum, Integer jNum, Integer aNum) {
        TPaper paper = new TPaper();

        paper.setAnswer(itAnswerService.createTAnswerExams(tid, aNum));
        paper.setChoose(itChooseService.createTChooseExams(tid, cNum));
        paper.setJudge(itJudgeService.createTJudgeExams(tid, jNum));
        paper.setTid(tid);

        try {
            paperService.insertTPaper(paper);
            return new AjaxResult(1, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"生成失败");
        }
    }


}
