package com.hzgc.project.system.custom.controller;

import com.hzgc.framework.web.controller.BaseController;
import com.hzgc.framework.web.domain.AjaxResult;
import com.hzgc.framework.web.page.TableDataInfo;
import com.hzgc.project.system.custom.domain.PzCustomer;
import com.hzgc.project.system.custom.domain.PzOrgan;
import com.hzgc.project.system.custom.domain.PzRightcustomer;
import com.hzgc.project.system.custom.service.ICustomerService;
import com.hzgc.project.system.custom.service.IOrganService;
import com.hzgc.project.system.custom.service.IRightcustomerService;
import com.hzgc.project.system.department.domain.PzDepartment;
import com.hzgc.project.system.department.service.IDepartmentService;
import com.hzgc.project.system.rightgroup.domain.PzRightgroup;
import com.hzgc.project.system.rightgroup.service.IRightgroupService;
import com.hzgc.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 菜单信息
 * 
 */
@Controller
@RequestMapping("/system/custom")
public class CustomController extends BaseController
{
    private String prefix = "system/custom";

    @Autowired
    private IOrganService organService;

    @Autowired
    private IRightcustomerService rightcustomerService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IRightgroupService rightgroupService;

    @Autowired
    private IUserService userService;

    @GetMapping("/organ")
    public String organ()
    {
        return prefix + "/organ";
    }


    @PostMapping("/organPage")
    @ResponseBody
    public TableDataInfo organPage()
    {
        startPage1("id");

        List<PzOrgan> list =organService.selectAll();
        return getDataTable(list);
    }

    /**
     * 修改企业
     * @return
     */
    @GetMapping("/editOrgan/{id}")
    public String editOrgan(ModelMap mmap,@PathVariable("id") Long id)
    {
        mmap.put("organ",organService.findById(id));
        return prefix + "/editOrgan";
    }


    @PostMapping("/editOrganSave")
    @ResponseBody
    public AjaxResult editOrganSave(PzOrgan organ)
    {

        return toAjax(organService.edit(organ));
    }
    /**
     * 新增保存
     */
    @GetMapping("/addOrgan")
    public String addOrgan()
    {
        return prefix + "/addOrgan";
    }


    /**
     * 新增保存企业
     */
    @PostMapping("/addOrganSave")
    @ResponseBody
    public AjaxResult addOrganSave(PzOrgan organ)
    {
        return toAjax(organService.add(organ));
    }

    @PostMapping("/delOrgan/{id}")
    @ResponseBody
    public AjaxResult delOrgan(@PathVariable("id")String id)
    {
        try
        {
            return toAjax(organService.del(id));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }




    @GetMapping("/customer")
    public String customer()
    {
        return prefix + "/customer";
    }


    @PostMapping("/customerPage")
    @ResponseBody
    public TableDataInfo customerPage()
    {
        startPage1("id");

        List<PzCustomer> list =customerService.selectAll();
        return getDataTable(list);
    }

    /**
     * 修改
     * @return
     */
    @GetMapping("/editCustomer/{id}")
    public String editCustomer(ModelMap mmap,@PathVariable("id") Integer id)
    {
        mmap.put("organ",organService.selectAll());
        mmap.put("customer",customerService.findById(id));
        mmap.put("user",userService.userMaintainPage(null,null,null ,null ,null,null,
                null,null,null,1));

        return prefix + "/editCustomer";
    }


    @PostMapping("/editCustomerSave")
    @ResponseBody
    public AjaxResult editCustomerSave(PzCustomer customer)
    {

        return toAjax(customerService.edit(customer));
    }
    /**
     * 新增
     */
    @GetMapping("/addCustomer")
    public String addCustomer(ModelMap mmap)
    {
        mmap.put("user",userService.userMaintainPage(null,null,null ,null ,null,null,
                null,null,null,1));
        mmap.put("organ",organService.selectAll());
        return prefix + "/addCustomer";
    }


    /**
     * 新增保存
     */
    @PostMapping("/addCustomerSave")
    @ResponseBody
    public AjaxResult addCustomerSave(PzCustomer customer)
    {
        return toAjax(customerService.add(customer));
    }

    @PostMapping("/delCustomer/{id}")
    @ResponseBody
    public AjaxResult delCustomer(@PathVariable("id")String id)
    {
        try
        {
            return toAjax(customerService.del(id));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }








    @GetMapping("/rightcustomer")
    public String rightcustomer()
    {
        return prefix + "/rightcustomer";
    }


    @PostMapping("/rightcustomerPage")
    @ResponseBody
    public TableDataInfo rightcustomerPage()
    {
        startPage1("id");

        List<PzRightcustomer> list =rightcustomerService.selectAll();
        return getDataTable(list);
    }

    /**
     * 修改
     * @return
     */
    @GetMapping("/editRightcustomer/{id}")
    public String editRightcustomer(ModelMap mmap,@PathVariable("id") Integer id)
    {
        mmap.put("customer", customerService.selectAll());
        mmap.put("rightgroup", rightgroupService.selectAll(new PzRightgroup()));
        mmap.put("rightcustomer",rightcustomerService.findById(id));
        return prefix + "/editRightcustomer";
    }


    @PostMapping("/editRightcustomerSave")
    @ResponseBody
    public AjaxResult editRightcustomerSave(PzRightcustomer rightcustomer)
    {

        return toAjax(rightcustomerService.edit(rightcustomer));
    }
    /**
     * 新增
     */
    @GetMapping("/addRightcustomer")
    public String addRightcustomer(ModelMap mmap)
    {
        mmap.put("customer", customerService.selectAll());
        mmap.put("rightgroup", rightgroupService.selectAll(new PzRightgroup()));
        return prefix + "/addRightcustomer";
    }


    /**
     * 新增保存
     */
    @PostMapping("/addRightcustomerSave")
    @ResponseBody
    public AjaxResult addRightcustomerSave(PzRightcustomer rightcustomer)
    {
        return toAjax(rightcustomerService.add(rightcustomer));
    }

    @PostMapping("/delRightcustomer/{id}")
    @ResponseBody
    public AjaxResult delRightcustomer(@PathVariable("id")String id)
    {
        try
        {
            return toAjax(rightcustomerService.del(id));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}