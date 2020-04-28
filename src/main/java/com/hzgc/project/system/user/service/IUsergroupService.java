package com.hzgc.project.system.user.service;


import com.hzgc.project.system.user.domain.PzUsergroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsergroupService {

    List<PzUsergroup> findUsergroupAll();

    PzUsergroup findUsergroupById(int usergroupid);

    String findUsergroupByName(String usergroupname);

    int updataByUserstatusById(PzUsergroup usergroup);

    int deUsergroupById(String userstatusid);

    int addUsergroup(PzUsergroup usergroup);

}
