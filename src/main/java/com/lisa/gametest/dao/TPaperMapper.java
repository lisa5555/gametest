package com.lisa.gametest.dao;


import com.lisa.gametest.entity.TChoose;
import com.lisa.gametest.entity.TJudge;
import com.lisa.gametest.entity.TPaper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPaperMapper {

    int deleteByPrimaryKey(Integer qid);

    int insertTPaper(TPaper paper);

    int updateByExample(@Param("record") TPaper record, @Param("example") TPaper example);

    int updateByPrimaryKeySelective(TPaper record);

    int updateByPrimaryKey(TPaper record);

    public TPaper findPaperById(Integer qid);
    public TChoose findchooseById(Integer id);
    public TJudge findjudgeById(Integer id);

}