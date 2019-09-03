package com.lisa.gametest.dao;


import com.lisa.gametest.entity.TChoose;
import com.lisa.gametest.entity.TJudge;
import com.lisa.gametest.entity.TPaper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPaperMapper {
    int countByExample(TPaper example);

    int deleteByExample(TPaper example);

    int deleteByPrimaryKey(Integer qid);

    int insert(TPaper record);

    int insertSelective(TPaper record);

    List<TPaper> selectByExample(TPaper example);

    TPaper selectByPrimaryKey(Integer qid);

    int updateByExampleSelective(@Param("record") TPaper record, @Param("example") TPaper example);

    int updateByExample(@Param("record") TPaper record, @Param("example") TPaper example);

    int updateByPrimaryKeySelective(TPaper record);

    int updateByPrimaryKey(TPaper record);
    public TPaper findPaperById(Integer qid);
    public TChoose findchooseById(Integer id);
    public TJudge findjudgeById(Integer id);

}