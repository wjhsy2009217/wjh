package com.hzgc.project.system.project.service;

import com.hzgc.project.system.project.domain.PzProject;
import com.hzgc.project.system.project.domain.PzProrgroup;

import java.util.List;
import java.util.Map;

/**
 * 菜单 业务层
 * 
 * @author wjh
 */
public interface IProjectService
{
    List<PzProject> getProject();

    PzProject getProjectById(int id,int userid);

    List<Map<String, Object>> projectTree(PzProrgroup prorgroup);

    void editProjectTree(int id,String projectid,String moduleid );

    List<PzProject> getProjectByUserid(int userid);
}
