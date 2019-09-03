package com.lisa.gametest.service;


import com.lisa.gametest.OverPaperVo.QuestionJosn;
import com.lisa.gametest.entity.TPaper;

import java.util.List;

public interface ITPaperService
{

public List<QuestionJosn> showquestions(Integer qid);
}
