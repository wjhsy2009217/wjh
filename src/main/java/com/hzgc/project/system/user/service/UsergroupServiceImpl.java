package com.hzgc.project.system.user.service;


import com.hzgc.common.support.Convert;
import com.hzgc.project.system.user.domain.PzUsergroup;
import com.hzgc.project.system.user.domain.PzUserstatus;
import com.hzgc.project.system.user.mapper.PzUsergroupMapper;
import com.hzgc.project.system.user.mapper.PzUserstatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsergroupServiceImpl implements IUsergroupService {

    @Autowired
    private PzUsergroupMapper pzUsergroupMapper;
    @Override
    public List<PzUsergroup> findUsergroupAll() {
        return pzUsergroupMapper.findUsergroupAll();
    }

    @Override
    public PzUsergroup findUsergroupById(int usergroupid) {
        return pzUsergroupMapper.findUsergroupById(usergroupid);
    }

    @Override
    public String findUsergroupByName(String usergroupname) {
        PzUsergroup pu = pzUsergroupMapper.findUsergroupByName(usergroupname);
        if(pu == null){
            return "0";
        }
        return "1";
    }

    @Override
    public int updataByUserstatusById(PzUsergroup usergroup) {
        return pzUsergroupMapper.updataByUserstatusById(usergroup);
    }

    @Override
    public int deUsergroupById(String userstatusid) {
        Long[] ids = Convert.toLongArray(userstatusid);
        return pzUsergroupMapper.deUsergroupById(ids);
    }

    @Override
    public int addUsergroup(PzUsergroup usergroup) {
        return pzUsergroupMapper.addUsergroup(usergroup);
    }
}
