package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TOverPaper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOverPaperMapper {
    int countByExample(TOverPaper example);

    int deleteByExample(TOverPaper example);

    int deleteByPrimaryKey(Integer oid);

    int insert(TOverPaper record);

    int insertSelective(TOverPaper record);

    List<TOverPaper> selectByExample(TOverPaper example);

    TOverPaper selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") TOverPaper record, @Param("example") TOverPaper example);

    int updateByExample(@Param("record") TOverPaper record, @Param("example") TOverPaper example);

    int updateByPrimaryKeySelective(TOverPaper record);

    int updateByPrimaryKey(TOverPaper record);
}