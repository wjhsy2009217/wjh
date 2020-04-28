package com.hzgc.project.system.user.mapper;


import com.hzgc.project.system.user.domain.PzUserstatus;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzUserstatusMapper {
    List<PzUserstatus> findUserstatusAll();

    PzUserstatus findUserstatusById(int userstatusid);

    PzUserstatus findUserstatusByName(String userstatusname);

    int updataByUserstatusById(PzUserstatus pzUserstatus);

    int addUserstatus(PzUserstatus pzUserstatus);

    int deluserstatusById(Long[] userstatusid);

}