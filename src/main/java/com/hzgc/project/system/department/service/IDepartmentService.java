package com.hzgc.project.system.department.service;


import com.hzgc.project.system.department.domain.PzDepartment;

import java.util.List;
import java.util.Map;

public interface IDepartmentService {
    List<PzDepartment> selectAll();

    List<Map<String, Object>> depaTree();

    PzDepartment findById(int departid);
}
