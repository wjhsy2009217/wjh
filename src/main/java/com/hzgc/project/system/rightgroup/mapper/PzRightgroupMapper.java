package com.hzgc.project.system.rightgroup.mapper;

import com.hzgc.project.system.rightgroup.domain.PzRightgroup;

import java.util.List;

public interface PzRightgroupMapper {
    List<PzRightgroup> selectAll(PzRightgroup rightgroup);

    PzRightgroup selectById(int rightgroupid);

    PzRightgroup selectByName(String rightgroupname);

    int edit(PzRightgroup rightgroup);

    int add(PzRightgroup rightgroup);

    int del(Long[] rightgroupid);
}