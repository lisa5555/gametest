package com.lisa.gametest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisa.gametest.OverPaperVo.PaperAnswerInfo;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.service.ITOverPaperService;
import com.lisa.gametest.service.ITUserService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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



    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ITOverPaperService overPaperService;

    @Autowired
    private ITUserService itUserService;

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
     * @param qid
     * @param info
     * @return
     */
    @RequestMapping("/correctExam")
    public AjaxResult correctExam(Integer qid, String info){
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<PaperAnswerInfo> lendReco = mapper.readValue(info,new TypeReference<List<PaperAnswerInfo>>() { });
            String username = redisTemplate.opsForValue().get("token");
            TUser user = itUserService.findByName(username);
            overPaperService.correctionPaper(qid, user.getUid(), lendReco);
            return new AjaxResult(1,null);

        } catch (IOException e) {
            e.printStackTrace();
            return new AjaxResult(0,"提交发生错误");
        }

    }
}
