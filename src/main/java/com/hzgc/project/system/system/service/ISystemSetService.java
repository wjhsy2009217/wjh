package com.hzgc.project.system.system.service;


import com.hzgc.project.system.system.domain.PzSystemSet;

public interface ISystemSetService {
    PzSystemSet findBySystemId(Integer id);

    int updateVariablecharById(Integer id, String variablechar);
}
