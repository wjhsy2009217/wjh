package com.hzgc.project.system.role.controller;

import com.hzgc.framework.aspectj.lang.annotation.Log;
import com.hzgc.framework.aspectj.lang.enums.BusinessType;
import com.hzgc.framework.web.controller.BaseController;
import com.hzgc.framework.web.domain.AjaxResult;
import com.hzgc.framework.web.page.TableDataInfo;
import com.hzgc.project.system.project.domain.PzProrgroup;
import com.hzgc.project.system.project.service.IProjectService;
import com.hzgc.project.system.rightgroup.domain.PzRightgroup;
import com.hzgc.project.system.rightgroup.service.IRightgroupService;
import com.hzgc.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/system/role")
public class RolesController extends BaseController
{
    private String prefix = "system/role";

    @Autowired
    private IRightgroupService rightgroupService;

    @Autowired
    private IProjectService projectService;
    @Autowired
    private IUserService userService;

    @GetMapping("/rightgroup")
    public String operlog()
    {
        return prefix + "/rightgroup";
    }

    @PostMapping("/rightgroupList")
    @ResponseBody
    public TableDataInfo rightgroupList(PzRightgroup rightgroup)
    {
        startPage1("rightgroupid");
        List<PzRightgroup> list = rightgroupService.selectAll(rightgroup);
        return getDataTable(list);
    }


    /**
     * 新增角色
     */
    @GetMapping("/addRightgroup")
    public String add()
    {
        return prefix + "/addRightgroup";
    }

    /**
     * 新增角色用户
     */
    @Log(title = "角色管理", businessType = BusinessType.INSERT)
    @PostMapping("/addRightgroup")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addRightgroup(PzRightgroup rightgroup)
    {

        return toAjax(rightgroupService.add(rightgroup));
    }

    /**
     * 修改角色
     */
    @GetMapping("/editRightgroup/{rightgroupid}")
    public String edit(@PathVariable("rightgroupid") int rightgroupid, ModelMap mmap)
    {
        mmap.put("rightgroup", rightgroupService.selectById(rightgroupid));
        return prefix + "/editRightgroup";
    }

    /**
     * 修改保存角色
     */
    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @PostMapping("/editRightgroup")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult rightgroupService(PzRightgroup rightgroup)
    {
        return toAjax(rightgroupService.edit(rightgroup));
    }

    @Log(title = "角色管理", businessType = BusinessType.DELETE)
    @PostMapping("/delRightgroup")
    @ResponseBody
    public AjaxResult delRightgroup(String ids)
    {
        try
        {
            return toAjax(rightgroupService.del(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
    /**
     * 校验角色名称
     */
    @PostMapping("/checkRightgroupnameUnique")
    @ResponseBody
    public String checkRightgroupnameUnique(String  rightgroupname)
    {
        return rightgroupService.selectByName(rightgroupname);
    }


    @GetMapping("/modrgroup")
    public String modrgroup()
    {
        return prefix + "/modrgroup";
    }

    /**
     * 加载角色菜单列表树
     */
    @GetMapping("/projectTree")
    @ResponseBody
    public List<Map<String, Object>> projectTree(PzProrgroup prorgroup)
    {
        List<Map<String, Object>> tree = projectService.projectTree(prorgroup);
        return tree;
    }

    @PostMapping("/editProjectTree")
    @ResponseBody
    public void editProjectTree(int id,String projectid,String moduleid )
    {
        projectService.editProjectTree(id,projectid,moduleid);
    }

    @GetMapping("/highRole")
    public String highRole()
    {
        return prefix + "/highRole";
    }

    @GetMapping("/highRoleTree")
    @ResponseBody
    public  List<Map<String, Object>> highRoleTree()
    {
        return rightgroupService.findHighRole();
    }



}
