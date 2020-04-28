package com.hzgc.project.system.rightgroup.service;

import com.hzgc.common.support.Convert;
import com.hzgc.project.system.rightgroup.mapper.PzRightgroupMapper;
import com.hzgc.project.system.rightgroup.domain.PzRightgroup;
import com.hzgc.project.system.user.domain.PzUser;
import com.hzgc.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RightgroupServiceImpl implements IRightgroupService {
    @Autowired
    private PzRightgroupMapper pzRightgroupMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<PzRightgroup> selectAll(PzRightgroup rightgroup){
        return pzRightgroupMapper.selectAll(rightgroup);
    }

    @Override
    public PzRightgroup selectById(int rightgroupid) {
        return pzRightgroupMapper.selectById(rightgroupid);
    }

    @Override
    public String selectByName(String rightgroupname) {
        PzRightgroup pr = pzRightgroupMapper.selectByName(rightgroupname);
        if(pr == null){
            return "0";
        }
        return "1";
    }

    @Override
    public int edit(PzRightgroup rightgroup) {
        return pzRightgroupMapper.edit(rightgroup);
    }

    @Override
    public int add(PzRightgroup rightgroup) {
        return pzRightgroupMapper.add(rightgroup);
    }

    @Override
    public int del(String rightgroupid) {
        Long[] ids = Convert.toLongArray(rightgroupid);
        return pzRightgroupMapper.del(ids);
    }

    @Override
    public List<Map<String, Object>> findHighRole() {
        PzRightgroup r = new PzRightgroup();
        List<PzRightgroup> rList = pzRightgroupMapper.selectAll(r);
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        Map<String, Object> deptMap = new HashMap<String, Object>();
        deptMap.put("id", 999);
        deptMap.put("pId", 0);
        deptMap.put("name","杭州平治");
        deptMap.put("title", "杭州平治");
        trees.add(deptMap);
        for(PzRightgroup list : rList){
            Map<String, Object> deptMap1 = new HashMap<String, Object>();
            deptMap1.put("id", list.getRightgroupid());
            deptMap1.put("pId", 999);
            deptMap1.put("name", list.getRightgroupname());
            deptMap1.put("title", list.getRightgroupname());
            trees.add(deptMap1);
        }

        return trees;
    }

}
