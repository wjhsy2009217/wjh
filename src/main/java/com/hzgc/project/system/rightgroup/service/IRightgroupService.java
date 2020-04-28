package com.hzgc.project.system.rightgroup.service;

import com.hzgc.project.system.rightgroup.domain.PzRightgroup;

import java.util.List;
import java.util.Map;

public interface IRightgroupService {
    List<PzRightgroup> selectAll(PzRightgroup rightgroup);

    PzRightgroup selectById(int rightgroupid);

    String selectByName(String rightgroupname);

    int edit(PzRightgroup rightgroup);

    int add(PzRightgroup rightgroup);

    int del(String rightgroupid);

    List<Map<String, Object>> findHighRole();
}
