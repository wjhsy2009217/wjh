package com.hzgc.project.system.project.mapper;


import com.hzgc.project.system.project.domain.PzProject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PzProjectMapper {
    List<PzProject> getProject();

    PzProject getProjectById(@Param("projectid") int projectid, @Param("userid")int userid);

    List<PzProject> getProjectByUserid(int userid);

}