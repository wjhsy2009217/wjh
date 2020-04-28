package com.hzgc.project.system.system.controller;

import com.hzgc.common.utils.poi.ExcelUtil;
import com.hzgc.framework.aspectj.lang.annotation.Log;
import com.hzgc.framework.aspectj.lang.enums.BusinessType;
import com.hzgc.framework.web.controller.BaseController;
import com.hzgc.framework.web.domain.AjaxResult;
import com.hzgc.framework.web.page.TableDataInfo;
import com.hzgc.project.system.post.domain.Post;
import com.hzgc.project.system.system.domain.PzSystemSet;
import com.hzgc.project.system.system.service.ISystemSetService;
import com.hzgc.project.system.user.domain.PzUserInfo;
import com.hzgc.project.system.user.domain.User;
import com.hzgc.project.system.user.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 系统信息操作处理
 * 
 * @author wjh
 */
@Controller
@RequestMapping("/system/system")
public class SystemController extends BaseController
{
    private String prefix = "system/system";

    @Autowired
    private ISystemSetService systemSetService;

    @Autowired
    private IUserInfoService userInfoService;




    /**
     * 保存修改企业名称
     */
    @GetMapping("/editSystemSet")
    public String editSystemSet(ModelMap mmap, HttpSession session)
    {
        PzUserInfo user = (PzUserInfo)session.getAttribute("user");
        mmap.put("systemSet", systemSetService.findBySystemId(user.getUserid().intValue()));
        return prefix + "/systemSet";
    }

    @Log(title = "企业名称修改", businessType = BusinessType.UPDATE)
    @PostMapping("/saveEditSystemSet")
    @ResponseBody
    public String saveEditSystemSet(int sid,String variablechar)
    {
        systemSetService.updateVariablecharById(sid,variablechar);
        return "redirect:"+prefix+"/editSystemSet/"+sid;
    }
    /**
     * 保存修改系统参数
     */
    @GetMapping("/editSystemParam")
    public String editSystemParam(ModelMap mmap,HttpSession session)
    {
        PzUserInfo user = (PzUserInfo)session.getAttribute("user");
        mmap.put("params", userInfoService.selectByUserId(user.getUserid()));
        return prefix + "/systemParam";
    }

    @Log(title = "系统参数修改", businessType = BusinessType.UPDATE)
    @PostMapping("/saveEditSystemParam")
    @ResponseBody
    public String saveEditSystemParam(Long userid,String operatortheme,String operatorlan,String operatorskin,int loginerror)
    {
        userInfoService.updateByUserId(userid,operatortheme,operatorlan,operatorskin,loginerror);
        return "redirect:"+prefix+"/editSystemParam/"+userid;
    }

}
