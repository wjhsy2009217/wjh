package com.hzgc.project.system.user.service;


import com.hzgc.project.system.user.domain.PzTechtitle;
import com.hzgc.project.system.user.domain.PzUserstatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserstatusService {

    List<PzUserstatus> findUserstatusAll();

    PzUserstatus findUserstatusById(int userstatusid);

    String findUserstatusByName(String userstatusname);

    int updataByUserstatusById(PzUserstatus pzUserstatus);

    int addUserstatus(PzUserstatus pzUserstatus);

    int deluserstatusById(String userstatusid);

}
