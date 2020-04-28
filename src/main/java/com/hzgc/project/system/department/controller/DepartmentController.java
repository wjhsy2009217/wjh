package com.hzgc.project.system.department.controller;

import com.hzgc.framework.aspectj.lang.annotation.Log;
import com.hzgc.framework.aspectj.lang.enums.BusinessType;
import com.hzgc.framework.web.controller.BaseController;
import com.hzgc.framework.web.domain.AjaxResult;
import com.hzgc.framework.web.page.TableDataInfo;
import com.hzgc.project.system.department.domain.PzDepartment;
import com.hzgc.project.system.department.service.IDepartmentService;
import com.hzgc.project.system.menu.domain.Menu;
import com.hzgc.project.system.menu.service.IMenuService;
import com.hzgc.project.system.role.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 菜单信息
 * 
 * @author zyd
 */
@Controller
@RequestMapping("/system/depa")
public class DepartmentController extends BaseController
{
    private String prefix = "system/department";

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping()
    public String department()
    {
        return prefix + "/depa";
    }


    @PostMapping("/departmentPage")
    @ResponseBody
    public TableDataInfo departmentPage(Integer rightgroupid)
    {
        startPage1("departid");
        List<PzDepartment> list =departmentService.selectAll();
        return getDataTable(list);
    }

    @GetMapping("/depaTree")
    @ResponseBody
    public  List<Map<String, Object>> depaTree()
    {
        return departmentService.depaTree();
    }

    @GetMapping("/editDepa/{departid}")
    public String editDepa( ModelMap mmap,@PathVariable("departid")Integer departid)
    {
        mmap.put("depa",departmentService.findById(departid));
        return prefix + "/editDepa";
    }


}