package com.hzgc.project.system.user.service;


import com.hzgc.common.constant.UserConstants;
import com.hzgc.common.support.Convert;
import com.hzgc.common.utils.Md5Utils;
import com.hzgc.project.system.user.domain.PzTechtitle;
import com.hzgc.project.system.user.domain.PzUserInfo;
import com.hzgc.project.system.user.mapper.PzTechtitleMapper;
import com.hzgc.project.system.user.mapper.PzUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechtitleServiceImpl implements ITechtitleService {
    @Autowired
    private PzTechtitleMapper pzTechtitleMapper;


    @Override
    public List<PzTechtitle> techtitleForPage() {
        return pzTechtitleMapper.techtitleForPage();
    }

    @Override
    public String checkTechtitlenameUnique(String old) {
        PzTechtitle pt = pzTechtitleMapper.checkTechtitlenameUnique(old);
        if(pt == null){
            return "0";
        }
        return "1";
    }

    @Override
    public int insertTechtitle(PzTechtitle techtitle) {
        return pzTechtitleMapper.insertTechtitle(techtitle);
    }

    @Override
    public PzTechtitle findTechtitleById(int techtitleid) {
        return pzTechtitleMapper.findTechtitleById(techtitleid);
    }

    @Override
    public int editTechtitleById(PzTechtitle techtitle) {
        return pzTechtitleMapper.editTechtitleById(techtitle);
    }



    @Override
    public int delTechtitleById(String techtitleid) {
        Long[] ids = Convert.toLongArray(techtitleid);
        return pzTechtitleMapper.delTechtitleById(ids);
    }
}
