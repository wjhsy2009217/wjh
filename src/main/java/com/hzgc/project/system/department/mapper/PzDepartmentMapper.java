package com.hzgc.project.system.department.mapper;

import com.hzgc.project.system.department.domain.PzDepartment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzDepartmentMapper {

    List<PzDepartment> selectAll();

    PzDepartment findById(int departid);
}