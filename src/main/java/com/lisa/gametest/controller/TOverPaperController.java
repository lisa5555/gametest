package com.lisa.gametest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisa.gametest.OverPaperVo.PaperAnswerInfo;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TChoose;
import com.lisa.gametest.entity.TTestNumber;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.service.ITChooseService;
import com.lisa.gametest.service.ITOverPaperService;
import com.lisa.gametest.service.ITTestNumberService;
import com.lisa.gametest.service.ITUserService;
import com.lisa.gametest.vo.AnswerExam;
import com.lisa.gametest.vo.AnswerExamList;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/overpaper")
public class TOverPaperController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ITChooseService itChooseService;

    @Autowired
    private ITOverPaperService overPaperService;

    @Autowired
    private ITUserService itUserService;

    @Autowired
    private ITTestNumberService itestNumberService;

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


    /**
     * 提交试卷
     * @param kid
     * @param info
     * @return
     */
    @RequestMapping("/correctExam.do")
    public AjaxResult correctExam(Integer kid, String info, String answerList ){

        System.out.println(info);
        ObjectMapper mapper = new ObjectMapper();
        try {
            TTestNumber testNumber = itestNumberService.findById(kid);
            List<PaperAnswerInfo> lendReco = mapper.readValue(info,new TypeReference<List<PaperAnswerInfo>>() { });
            String username = redisTemplate.opsForValue().get("token");
            TUser user = itUserService.findByName(username);
            overPaperService.correctionPaper(testNumber.getQid(), user.getUid(), lendReco,answerList );
            return new AjaxResult(1,null);

        } catch (IOException e) {
            e.printStackTrace();
            return new AjaxResult(0,"提交发生错误");
        }

    }






}
