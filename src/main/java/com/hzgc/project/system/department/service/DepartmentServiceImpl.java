package com.hzgc.project.system.department.service;

import com.hzgc.project.system.department.domain.PzDepartment;
import com.hzgc.project.system.department.mapper.PzDepartmentMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
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

    @Override
    public int add(PzDepartment department) {
        int maxid = pzDepartmentMapper.findMaxId()+1;

        if(department.getDepartfartherid() == 0){
            department.setDepartfullname(department.getDepartname());
            department.setDepartfullid(maxid+"");
        } else {
            PzDepartment pzDepartment = pzDepartmentMapper.findById(department.getDepartfartherid());
            department.setDepartfullname(pzDepartment.getDepartfullname()+"/"+department.getDepartname());
            department.setDepartfullid(pzDepartment.getDepartfullid()+"/"+maxid);
        }
        if(department.getSort() == null){
            department.setSort(0);
        }

        return pzDepartmentMapper.add(department);
    }

    @Override
    public List<PzDepartment> findByFid(int departfartherid) {
        return pzDepartmentMapper.findByFid(departfartherid);
    }

    @Override
    public int edit(PzDepartment department) {

        PzDepartment d =  pzDepartmentMapper.findById(department.getDepartid());
        PzDepartment d2 = new PzDepartment();
        try {
            BeanUtils.copyProperties(d2,department);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //查询有无父部门 不同命名方式
        if(d.getDepartfartherid() > 0){
            PzDepartment d1 =  pzDepartmentMapper.findById(d.getDepartfartherid());
            d2.setDepartfullname(d1.getDepartfullname()+"/"+department.getDepartname());
        } else{
            d2.setDepartfullname(department.getDepartname());
        }
        d2.setDepartfartherid(d.getDepartfartherid());
        //获取下面的子部门 同样修改名称
        pzDepartmentMapper.edit(d2);
        d.setDepartfullid(d.getDepartfullid()+"%");
        List<PzDepartment> departmentList = pzDepartmentMapper.findByFullidNotDepartid(d);
        for(int i = 0;i<departmentList.size();i++){
            PzDepartment d1 = new PzDepartment();
            d1 = departmentList.get(i);
            d1.setDepartfullname(d2.getDepartfullname()+"/"+d1.getDepartfullname().substring(department.getDepartfullname().length()+1));
            pzDepartmentMapper.edit(d1);
        }
        //判断是否需要转移部门 空为不需要转移
        if(department.getDepartfartherid() != null){
            //修改部门以及子部门
            return updateSonDepa(department);
        }
        return 1;
    }

    private int updateSonDepa(PzDepartment department){
        //先查询要修改的父部门
        PzDepartment d = pzDepartmentMapper.findById(department.getDepartid());
        //如没有父部门的修改名称方式
        List<PzDepartment> departmentList = pzDepartmentMapper.findByFullId(department.getDepartfullid()+"%");
        if(d.getDepartfartherid() == 0){
            //查询该部门下的所有子部门
            PzDepartment d2 = pzDepartmentMapper.findById(department.getDepartfartherid());
            for(int i = 0 ;i <departmentList.size();i++ ){
                PzDepartment depa = new PzDepartment();
                depa = departmentList.get(i);
                //第一个需要修改fatherid
                if(i == 0){
                    depa.setDepartfartherid(d2.getDepartid());
                }
                depa.setDepartfullname(d2.getDepartfullname()+"/"+depa.getDepartfullname());
                depa.setDepartfullid(d2.getDepartfullid()+"/"+depa.getDepartfullid());
                pzDepartmentMapper.edit(depa);
            }

        } else {
            //有父部门 移动到其他地方的命名方式
            //先查询该父部门的fullname，进行数据操作
            PzDepartment d2 = pzDepartmentMapper.findById(d.getDepartfartherid());
            //查询未来父部门的属性
            PzDepartment d3 = pzDepartmentMapper.findById(department.getDepartfartherid());
            //计算父部门的名称长度 删除父部门前面的名称
            int nameSize = d2.getDepartfullname().length()+1;
            int idSize = d2.getDepartfullid().length()+1;
            for(int i = 0 ;i <departmentList.size();i++ ){
                PzDepartment depa = new PzDepartment();
                depa = departmentList.get(i);
                //d3为空则代表把部门移到第一级别
                if(d3 == null){
                    if(i == 0){
                        depa.setDepartfartherid(0);
                    }
                    depa.setDepartfullname(depa.getDepartfullname().substring(nameSize));
                    depa.setDepartfullid(depa.getDepartfullid().substring(idSize));
                } else {
                    if(i == 0){
                        depa.setDepartfartherid(d3.getDepartid());
                    }
                    depa.setDepartfullname(d3.getDepartfullname()+"/"+depa.getDepartfullname().substring(nameSize));
                    depa.setDepartfullid(d3.getDepartfullid()+"/"+depa.getDepartfullid().substring(idSize));
                }

                pzDepartmentMapper.edit(depa);
            }
        }
        return 1;
    }

    @Override
    public int delDepart(int departid) {
        List<PzDepartment> departmentList = pzDepartmentMapper.findByFid(departid);
        if(departmentList.size()>0){
            return 0;
        }
        int result = pzDepartmentMapper.delDepart(departid);
        if(result > 0){
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public String checkLoginNameUnique(String departfartherid, String departid) {
        if(departfartherid.equals(departid)){
            return "已在本部门下，无法转移";
        } else {
            PzDepartment pzd = pzDepartmentMapper.findById(Integer.parseInt(departid));
            PzDepartment pzd2 = new PzDepartment();
            pzd2.setDepartfullid(pzd.getDepartfullid()+"%");
            pzd2.setDepartid(Integer.parseInt(departid));
            List<PzDepartment> depaList = pzDepartmentMapper.findByFullidNotDepartid(pzd2);
            for(PzDepartment dlist: depaList ){
                if(Integer.parseInt(departfartherid) == dlist.getDepartid()){
                    return "无法把部门转移到自己子部门下";
                }
            }
        }
        return "success";
    }


}
