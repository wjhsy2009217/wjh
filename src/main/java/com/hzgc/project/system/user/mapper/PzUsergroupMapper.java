package com.hzgc.project.system.user.mapper;


import com.hzgc.project.system.user.domain.PzUsergroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzUsergroupMapper {

    List<PzUsergroup> findUsergroupAll();

    PzUsergroup findUsergroupById(int usergroupid);

    PzUsergroup findUsergroupByName(String usergroupname);

    int updataByUserstatusById(PzUsergroup usergroup);

    int deUsergroupById(Long[] userstatusid);

    int addUsergroup(PzUsergroup usergroup);

}