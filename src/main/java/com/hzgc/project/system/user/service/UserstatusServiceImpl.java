package com.hzgc.project.system.user.service;


import com.hzgc.common.support.Convert;
import com.hzgc.common.utils.Md5Utils;
import com.hzgc.project.system.user.domain.PzUserInfo;
import com.hzgc.project.system.user.domain.PzUserstatus;
import com.hzgc.project.system.user.mapper.PzUserInfoMapper;
import com.hzgc.project.system.user.mapper.PzUserstatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserstatusServiceImpl implements IUserstatusService {

    @Autowired
    private PzUserstatusMapper pzUserstatusMapper;

    @Override
    public List<PzUserstatus> findUserstatusAll() {
        return pzUserstatusMapper.findUserstatusAll();
    }

    @Override
    public PzUserstatus findUserstatusById(int userstatusid) {
        return pzUserstatusMapper.findUserstatusById(userstatusid);
    }

    @Override
    public String findUserstatusByName(String userstatusname) {
        PzUserstatus pu = pzUserstatusMapper.findUserstatusByName(userstatusname);
        if(pu == null){
            return "0";
        }
        return "1";
    }

    @Override
    public int updataByUserstatusById(PzUserstatus pzUserstatus) {
        return pzUserstatusMapper.updataByUserstatusById(pzUserstatus);
    }

    @Override
    public int addUserstatus(PzUserstatus pzUserstatus) {
        return pzUserstatusMapper.addUserstatus(pzUserstatus);
    }

    @Override
    public int deluserstatusById(String userstatusid) {
        Long[] ids = Convert.toLongArray(userstatusid);
        return pzUserstatusMapper.deluserstatusById(ids);
    }
}
