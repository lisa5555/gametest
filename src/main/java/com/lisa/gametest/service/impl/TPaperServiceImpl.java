package com.lisa.gametest.service.impl;



import com.lisa.gametest.OverPaperVo.QuestionJosn;
import com.lisa.gametest.dao.TPaperMapper;
import com.lisa.gametest.entity.TChoose;
import com.lisa.gametest.entity.TJudge;
import com.lisa.gametest.entity.TPaper;
import com.lisa.gametest.service.ITPaperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TPaperServiceImpl implements ITPaperService
{
    @Autowired(required = false)
    private TPaperMapper paperMapper;

    @Override
    public List<QuestionJosn> showquestions(Integer qid) {
        TPaper paper = paperMapper.findPaperById(qid);

        List<QuestionJosn> list = new ArrayList();
        String choose = paper.getChoose();
        String judge = paper.getJudge();
        String[] idArr = choose.split(",");
        String[] idArr2 = judge.split(",");
        int[] id = new int[idArr.length+idArr2.length];
        for (int i = 0; i <idArr.length;i++ ){
            QuestionJosn questionJosn = new QuestionJosn();
            id[i] = Integer.parseInt(idArr[i]);
            TChoose choose1 = paperMapper.findchooseById(id[i]);
            System.out.println(id[i]);
            questionJosn.setQuestionId(idArr[i]);
            questionJosn.setQuestionTitle(choose1.getComent());
            questionJosn.setQuestionItems(choose1.getAxuanxiang()+";"+choose1.getBxuanxiang()+";"
                    +choose1.getCxuanxiang()+";"+choose1.getDxuanxiang());
            questionJosn.setQuestionAnswer(choose1.getCorrect());
            System.out.println(choose1);
            list.add(questionJosn);
        }
        for (int i = idArr.length; i <idArr.length+idArr.length;i++ ){
            QuestionJosn questionJosn = new QuestionJosn();
            id[i] = Integer.parseInt(idArr[i-idArr.length]);
            TJudge tJudge = paperMapper.findjudgeById(id[i]);
            questionJosn.setQuestionId(idArr2[i-idArr.length]);
            questionJosn.setQuestionTitle(tJudge.getComent());
            questionJosn.setQuestionItems("√;×");
            questionJosn.setQuestionAnswer(tJudge.getCorrect());
            list.add(questionJosn);
        }
        return list;
    }
}
