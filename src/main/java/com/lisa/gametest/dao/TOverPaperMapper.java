package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TOverPaper;

import com.lisa.gametest.vo.overPaperInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOverPaperMapper {

    /**
     * 展示所有做完题目的方法
     * @return 返回值为所有做完题目的列表
     */
    //public List<TOverPaper> findAllTOverPaper();


   //public List<TOverPaper> findAllTOverPaper2();

    public List<overPaperInfo> findAllTP(@Param("typeName") String typeName,@Param("name") String name);


    /**
     * 查询试题状态的方法，状态码： 0为打分完毕的卷子，1为未打分的卷子
     * @param oid
     */
    public List<overPaperInfo> findByState(Integer oid);


    /**
     * 添加考生做完题目方法
     * @param tOverPaper 参数为 TOverPaper 对象
     */
    public void addTOverPaper(TOverPaper tOverPaper);


    /**
     * 删除考生做完题目方法
     * @param oid 参数为做完题目的id
     */
    public void deleteById(Integer oid);


    /**
     * 查询单个做完题目的方法
     * @param oid 参数为题目的id
     * @return 返回值是根据oid查询到的一个 TOverPaper 对象
     */
    public TOverPaper findById(Integer oid);


    /**
     * 修改分数方法
     * @param tOverPaper
     */
    public void updateTOverPaper(TOverPaper tOverPaper);


    public Integer deleteAll(int[] oidArr);
}