package com.hzgc.project.system.department.service;

import com.hzgc.project.system.department.domain.PzDepartment;
import com.hzgc.project.system.department.mapper.PzDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private PzDepartmentMapper pzDepartmentMapper;
    @Override
    public List<PzDepartment> selectAll(){
        return pzDepartmentMapper.selectAll();
    }

    @Override
    public List<Map<String, Object>> depaTree() {
        List<PzDepartment> dList = pzDepartmentMapper.selectAll();
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        Map<String, Object> deptMap = new HashMap<String, Object>();
        deptMap.put("id", 0);
        deptMap.put("pId", -1);
        deptMap.put("name","杭州平治");
        deptMap.put("title", "杭州平治");
        trees.add(deptMap);
        for(PzDepartment list : dList){
            Map<String, Object> deptMap1 = new HashMap<String, Object>();
            deptMap1.put("id", list.getDepartid());
            deptMap1.put("pId",list.getDepartfartherid());
            deptMap1.put("name", list.getDepartname());
            deptMap1.put("title", list.getDepartfullname());
            trees.add(deptMap1);
        }

        return trees;
    }

    @Override
    public PzDepartment findById(int departid) {
        return pzDepartmentMapper.findById(departid);
    }

}
