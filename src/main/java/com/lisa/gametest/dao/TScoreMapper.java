package com.lisa.gametest.dao;


import com.lisa.gametest.vo.voScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TScoreMapper {

    public List<voScore> findAllScore(@Param("typeName") String typeName,
                                      @Param("name") String name);

    public void deleteById(Integer sid);

    /**
     * 平均分
     * @param typeName
     * @return
     */
    public List<voScore> findAllTypeName(String typeName);

    /**
     * 总分
     * @param typeName
     * @return
     */
    public List<voScore> findByTypeNameSUM(String typeName);

    public Integer deleteAll(int[] sidArr);

}