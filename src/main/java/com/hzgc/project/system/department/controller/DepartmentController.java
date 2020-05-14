package com.hzgc.project.system.department.controller;

import com.hzgc.framework.web.controller.BaseController;
import com.hzgc.framework.web.domain.AjaxResult;
import com.hzgc.framework.web.page.TableDataInfo;
import com.hzgc.project.system.department.domain.PzDepartment;
import com.hzgc.project.system.department.service.IDepartmentService;
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

    @GetMapping("/depart")
    public String depart()
    {
        return prefix + "/depa";
    }


    @PostMapping("/departmentPage")
    @ResponseBody
    public TableDataInfo departmentPage(Integer departfartherid)
    {
        startPage1("departid");
        if(departfartherid == null){
            departfartherid = 0;
        }
        List<PzDepartment> list =departmentService.findByFid(departfartherid);
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

    /**
     * 新增保存班组
     */
    @PostMapping("/editDapa")
    @ResponseBody
    public AjaxResult editDapaSave(PzDepartment department)
    {

        return toAjax(departmentService.edit(department));
    }

    @GetMapping("/addDepa")
    public String addDepa()
    {
        return prefix + "/addDepa";
    }

    /**
     * 新增保存班组
     */
    @PostMapping("/addDepaSave")
    @ResponseBody
    public AjaxResult addDepaSave(PzDepartment department)
    {
        return toAjax(departmentService.add(department));
    }

    @PostMapping("/delDepa")
    @ResponseBody
    public AjaxResult delDepa(int ids)
    {
        try
        {
            return toAjax(departmentService.delDepart(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}