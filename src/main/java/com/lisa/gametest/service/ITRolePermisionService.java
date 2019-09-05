package com.lisa.gametest.service;


import com.lisa.gametest.entity.TRolePermision;
import com.lisa.gametest.vo.PersionInfo;

import java.util.List;

public interface ITRolePermisionService {
    public List<PersionInfo> findPersionById(Integer rid);
    public void deleteById(Integer rid, Integer pid);
    public void add(Integer rid, Integer pid);
}
