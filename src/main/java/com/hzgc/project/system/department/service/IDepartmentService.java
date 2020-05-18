package com.hzgc.project.system.department.service;


import com.hzgc.project.system.department.domain.PzDepartment;

import java.util.List;
import java.util.Map;

public interface IDepartmentService {
    List<PzDepartment> selectAll();

    List<Map<String, Object>> depaTree();

    PzDepartment findById(int departid);

    int add(PzDepartment department);

    List<PzDepartment> findByFid(int departfartherid);

    int edit(PzDepartment department);

    int delDepart(int departid);

    String checkLoginNameUnique(String departfartherid,String departid);

}
