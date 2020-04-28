package com.hzgc.project.system.project.mapper;


import com.hzgc.project.system.project.domain.PzModulegroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzModulegroupMapper {
    List<PzModulegroup> findById(int id);

}