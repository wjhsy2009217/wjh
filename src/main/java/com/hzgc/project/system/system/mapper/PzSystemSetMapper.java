package com.hzgc.project.system.system.mapper;

import com.hzgc.project.system.system.domain.PzSystemSet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PzSystemSetMapper {
    PzSystemSet findBySystemId(@Param("id")Integer id);

    int updateVariablecharById(@Param("id") Integer id, @Param("variablechar") String variablechar);
}