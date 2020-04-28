package com.hzgc.project.system.project.service;

import com.hzgc.project.system.project.domain.*;
import com.hzgc.project.system.project.mapper.PzModrgroupMapper;
import com.hzgc.project.system.project.mapper.PzModulegroupMapper;
import com.hzgc.project.system.project.mapper.PzProjectMapper;
import com.hzgc.project.system.project.mapper.PzProrgroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 菜单 业务层处理
 * 
 * @author wjh
 */
@Service
public class ProjectServiceImpl implements IProjectService
{

    @Autowired
    private PzProjectMapper pzProjectMapper;

    @Autowired
    private PzProrgroupMapper prorgroupMapper;

    @Autowired
    private PzModrgroupMapper modrgroupMapper;



    @Override
    public List<PzProject> getProject() {
        List<PzProject> pro = pzProjectMapper.getProject();

        return pzProjectMapper.getProject();
    }

    @Override
    public PzProject getProjectById(int id,int userid) {
        return pzProjectMapper.getProjectById(id,userid);
    }

    /**
     *获取权限列表
     * @param prorgroup
     * @return
     */
    @Override
    public List<Map<String, Object>> projectTree(PzProrgroup prorgroup)
    {
        int id = prorgroup.getRightgroupid();
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        List<PzProject> proList = pzProjectMapper.getProject();
        List<PzProrgroup> prorgroupList = prorgroupMapper.findById(id);
        List<PzModrgroup> modulegroupList = modrgroupMapper.findById(id);
        trees = getTrees(proList,prorgroupList,modulegroupList);
        return trees;
    }

    @Override
    public void editProjectTree(int id, String projectid, String moduleid) {
        String[] pro =  projectid.split(",");
        String[] module = moduleid.split(",");
        int[] pros = new int[pro.length];
        int[] modules = new int[module.length];
        List<PzModrgroup> mList = new ArrayList<PzModrgroup>();
        List<PzProrgroup> pList = new ArrayList<PzProrgroup>();
        if(!projectid.equals("")){
            for(int i=0;i<pro.length;i++){
                PzProrgroup pror = new PzProrgroup();
                pror.setProjectid(Integer.parseInt(pro[i]));
                pror.setRightgroupid(id);
                pror.setCreatetime(new Date());
                pList.add(pror);
            }
        }
        if(!moduleid.equals("")){
           for(int i=0;i<modules.length;i++){
               PzModrgroup mod = new PzModrgroup();
               mod.setRightgroupid(id);
               mod.setModuleid(Integer.parseInt(module[i]));
               mod.setCreatetime(new Date());
               mod.setModifytime(new Date());
               mList.add(mod);
           }
        }
        if(modrgroupMapper.delById(id)>=0){
            if(mList.size() > 0){
                modrgroupMapper.add(mList);
            }
        }
        if(prorgroupMapper.delById(id) >= 0){
            if(pList.size()>0){
                prorgroupMapper.add(pList);
            }
        }

    }

    @Override
    public List<PzProject> getProjectByUserid(int userid) {
        return pzProjectMapper.getProjectByUserid(userid);
    }

    /**
     * 对象转菜单树
     * @param proList
     * @param prorgroupList
     * @return
     */
    public List<Map<String, Object>> getTrees(List<PzProject> proList,List<PzProrgroup> prorgroupList,List<PzModrgroup> modulegroupList)
    {
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        for (PzProject pro : proList){
            Map<String, Object> deptMap = new HashMap<String, Object>();
            deptMap.put("id", pro.getProjectid());
            deptMap.put("pId", 0);
            deptMap.put("name", pro.getProjectname());
            deptMap.put("title", pro.getProjectname());
            deptMap.put("level", 0);
            boolean checked = false;
            for(PzProrgroup ppr : prorgroupList){
                if(pro.getProjectid().equals(ppr.getProjectid())){
                    checked = true;
                    break;
                }
            }
            deptMap.put("checked", checked);
            trees.add(deptMap);

           for(PzModulegroup mg : pro.getPzModulegroups()){
               getModuleTree(pro,mg,modulegroupList,trees);
            }
        }
        return trees;
    }
    public void getModuleTree(PzProject pro,PzModulegroup mg,List<PzModrgroup> modulegroupList,List<Map<String, Object>> trees){
        if(mg.getModulegroupname()!= null){
            Map<String, Object> deptMap1 = new HashMap<String, Object>();
            boolean checked1 = false;
            deptMap1.put("id", mg.getModulegroupid());
            deptMap1.put("pId", pro.getProjectid());
            deptMap1.put("name", mg.getModulegroupname());
            deptMap1.put("title", mg.getModulegroupname());
            deptMap1.put("level", 1);
            for(PzModule pm : mg.getPzModules()){
                if(pm.getModulename()!= null){
                    boolean checked2 = false;
                    Map<String, Object> deptMap2 = new HashMap<String, Object>();
                    deptMap2.put("id", pm.getModuleid());
                    deptMap2.put("pId", mg.getModulegroupid());
                    deptMap2.put("name", pm.getModulename());
                    deptMap2.put("title", pm.getModulename());
                    deptMap2.put("level", 2);
                    for(PzModrgroup mdu:modulegroupList){
                        if(mdu.getModuleid().equals(pm.getModuleid())){
                            checked1 = true;
                            checked2 = true;
                            break;
                        }
                    }
                    deptMap2.put("checked", checked2);
                    trees.add(deptMap2);
                }
            }
            deptMap1.put("checked", checked1);
            trees.add(deptMap1);
        }
    }

}
