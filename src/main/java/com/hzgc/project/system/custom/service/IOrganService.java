package com.hzgc.project.system.custom.service;


import com.hzgc.project.system.custom.domain.PzOrgan;
import com.hzgc.project.system.department.domain.PzDepartment;

import java.util.List;
import java.util.Map;

public interface IOrganService {

    List<PzOrgan> selectAll();

    PzOrgan findById(Long id);

    int add(PzOrgan organ);

    int edit(PzOrgan organ);

    int del(String id);

}
