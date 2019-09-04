package com.lisa.gametest.service;


import com.lisa.gametest.entity.TPermision;
import com.lisa.gametest.vo.MyPermission;

import java.util.List;
import java.util.Map;

public interface ITPermisionService {
    public List<TPermision> findpermisionByName(Integer uid);

    public List<TPermision> findAll();

    public TPermision findTPermision(Integer pid);

    public Map<String, Object> findMyPermission(Integer page, Integer limit, Integer pid, String searchName);

    public Map<String, Object> findFirstTPermision(Integer page, Integer limit, String searchName);

    public Map<String, Object> findSecondTPermision(Integer page, Integer limit, Integer pid, String searchName);

    public int insertTPermision(TPermision tPermision);

    public int updateTPermision(TPermision tPermision);

    public int deleteTPermisionById(Integer pid);

    public int deleteTPermisionByIds(String[] ids);
}
