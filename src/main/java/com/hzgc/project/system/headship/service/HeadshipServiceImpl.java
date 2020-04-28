package com.hzgc.project.system.headship.service;


import com.hzgc.common.support.Convert;
import com.hzgc.project.system.headship.domain.PzHeadship;

import com.hzgc.project.system.headship.mapper.PzHeadshipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HeadshipServiceImpl implements IHeadshipService
{
   @Autowired
   private PzHeadshipMapper headshipMapper;


    @Override
    public List<PzHeadship> selectAll() {
        return headshipMapper.selectAll();
    }

    @Override
    public String checkHeadshipnameUnique(String old) {
        PzHeadship pz = headshipMapper.checkHeadshipnameUnique(old);
        if(pz == null){
            return "0";
        }
        return "1";
    }

    @Override
    public int insertHeadship(PzHeadship headship) {
        return headshipMapper.insertHeadship(headship);
    }

    @Override
    public PzHeadship findHeadshipById(int headshipid) {
        return headshipMapper.findHeadshipById(headshipid);
    }

    @Override
    public int editHeadshipById(PzHeadship headship) {
        return headshipMapper.editHeadshipById(headship);
    }

    @Override
    public int delHeadshipById(String headshipid) {
        Long[] ids = Convert.toLongArray(headshipid);
        return headshipMapper.delHeadshipById(ids);
    }
}
