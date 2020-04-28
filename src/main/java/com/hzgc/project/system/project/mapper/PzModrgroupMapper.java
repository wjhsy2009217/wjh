package com.hzgc.project.system.project.mapper;

import com.hzgc.project.system.project.domain.PzModrgroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzModrgroupMapper {
    List<PzModrgroup> findById(int rightgroupid);

    int delById(int rightgroupid);

    int add(@Param("mods")List<PzModrgroup> mods);
}