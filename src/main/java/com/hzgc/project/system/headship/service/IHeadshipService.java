package com.hzgc.project.system.headship.service;

import com.hzgc.project.system.headship.domain.PzHeadship;

import java.util.List;

/**
 * 岗位信息 服务层
 * 
 * @author zyd
 */
public interface IHeadshipService
{

    /**
     * 查询所有职务信息
     * @return
     */
    List<PzHeadship> selectAll();

    String checkHeadshipnameUnique(String old);

    int insertHeadship(PzHeadship headship);

    PzHeadship findHeadshipById(int headshipid);

    int editHeadshipById(PzHeadship headship);

    int delHeadshipById(String headshipid);


}
