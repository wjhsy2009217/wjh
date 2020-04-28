package com.hzgc.project.system.user.controller;

import java.util.List;

import com.hzgc.project.system.headship.domain.PzHeadship;
import com.hzgc.project.system.headship.service.IHeadshipService;
import com.hzgc.project.system.rightgroup.domain.PzRightgroup;
import com.hzgc.project.system.rightgroup.service.IRightgroupService;
import com.hzgc.project.system.user.domain.*;
import com.hzgc.project.system.user.service.ITechtitleService;
import com.hzgc.project.system.user.service.IUsergroupService;
import com.hzgc.project.system.user.service.IUserstatusService;
import com.hzgc.project.system.worktype.domain.PzWorktype;
import com.hzgc.project.system.worktype.service.IWorktypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.hzgc.common.utils.StringUtils;
import com.hzgc.common.utils.poi.ExcelUtil;
import com.hzgc.framework.aspectj.lang.annotation.Log;
import com.hzgc.framework.aspectj.lang.enums.BusinessType;
import com.hzgc.framework.web.controller.BaseController;
import com.hzgc.framework.web.domain.AjaxResult;
import com.hzgc.framework.web.page.TableDataInfo;
import com.hzgc.project.system.post.service.IPostService;
import com.hzgc.project.system.role.service.IRoleService;
import com.hzgc.project.system.user.service.IUserService;


/**
 * 用户信息
 * 
 * @author zyD
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController
{
    private String prefix = "system/user";

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPostService postService;

    @Autowired
    private IRightgroupService rightgroupService;

    @Autowired
    private ITechtitleService techtitleService;

    @Autowired
    private IUserstatusService userstatusService;

    @Autowired
    private IUsergroupService usergroupService;

    @Autowired
    private IHeadshipService headshipService;

    @Autowired
    private IWorktypeService worktypeService;


    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(User user)
    {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(User user)
    {
        List<User> list = userService.selectUserList(user);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("roles", roleService.selectRoleAll());
        mmap.put("posts", postService.selectPostAll());
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(User user)
    {
        if (StringUtils.isNotNull(user.getUserId()) && User.isAdmin(user.getUserId()))
        {
            return error("不允许修改超级管理员用户");
        }
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        mmap.put("user", userService.selectUserById(userId));
        mmap.put("roles", roleService.selectRolesByUserId(userId));
        mmap.put("posts", postService.selectPostsByUserId(userId));
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(User user)
    {
        if (StringUtils.isNotNull(user.getUserId()) && User.isAdmin(user.getUserId()))
        {
            return error("不允许修改超级管理员用户");
        }
        return toAjax(userService.updateUser(user));
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        mmap.put("user", userService.selectUserById(userId));
        return prefix + "/resetPwd";
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwd(User user)
    {
        return toAjax(userService.resetUserPwd(user));
    }

    @RequiresPermissions("system:user:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(userService.deleteUserByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(User user)
    {
        return userService.checkLoginNameUnique(user.getLoginName());
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(User user)
    {
        return userService.checkPhoneUnique(user);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(User user)
    {
        return userService.checkEmailUnique(user);
    }


    /**
     * 人员恢复页面
     */
    @GetMapping("/userRestore")
    public String userRestore(ModelMap mmap)
    {
        List<PzPost> post = postService.selectAll();
        mmap.put("post", post);
        return prefix + "/userRestor";
    }

   /**
     * 查询人员恢复表
         * @param
     * @return
     */
    @PostMapping("/userRestorePage")
    @ResponseBody
    public TableDataInfo userRestorePage(String loginName,String kind,String beginTime ,String endTime ,String depa,String sex,String poli,
                                         String post,String edu,String usernum)
    {
        startPage1("u.userid");
        List<PzUser> list = userService.userRestorePage(loginName,kind,beginTime ,endTime ,depa,sex,poli,
                post,edu,usernum,2);
        return getDataTable(list);
    }

    /**
     * 人员恢复
     * @param ids
     * @return
     */
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/removeUserRestore")
    @ResponseBody
    public AjaxResult removeUserRestore(String ids)
    {
        try
        {
            return toAjax(userService.deleteUserMaintainByIds(ids,1));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 修改密码页面
     */
    @GetMapping("/editPassword")
    public String editPassword()
    {
        return prefix + "/editPwd";
    }


    /**
     * 校验密码
     */
    @PostMapping("/checkPwdUnique")
    @ResponseBody
    public String checkPwdUnique(String old)
    {
        User user = getUser();
        return userService.checkPwdUnique(user.getUserId(),old);
    }

    /**
     * 保存修改密码
     */
    @PostMapping("/editPwd")
    public String editPwd(String pwd)
    {
        User user = getUser();
        userService.editUserPwd(user.getUserId().longValue(),pwd);
        return "redirect:editPassword";
    }

    /**
     * 人员恢复页面
     */
    @GetMapping("/userMaintain")
    public String userMaintain(ModelMap mmap)
    {
        PzRightgroup pr = new PzRightgroup();
        mmap.put("right",rightgroupService.selectAll(pr));
        mmap.put("post", postService.selectAll());
        return prefix + "/userMaintain";
    }
    /**
     * 查询人员维护表
     * @param
     * @return
     */
    @PostMapping("/userMaintainPage")
    @ResponseBody
    public TableDataInfo userMaintainPage(String loginName,String kind,String beginTime ,String endTime ,String depa,
                                         String post,String phone,String usernum,String rightgroup)
    {
        startPage1("u.userid");
        List<PzUser> list = userService.userMaintainPage(loginName,kind,beginTime ,endTime ,depa,rightgroup,
                post,phone,usernum,1);
        return getDataTable(list);
    }

    /**
     * 离职人员
     * @param ids
     * @return
     */
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/removeUserMaintain")
    @ResponseBody
    public AjaxResult removeUserMaintain(String ids)
    {
        try
        {
            return toAjax(userService.deleteUserMaintainByIds(ids,2));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 用户属性页面
     */
    @GetMapping("/userAttributes")
    public String userAttributes()
    {

        return prefix + "/userAttributes";
    }

    @PostMapping("/techtitleForPage")
    @ResponseBody
    public TableDataInfo techtitleForPage()
    {
        startPage1("techtitleid");
        List<PzTechtitle> list = techtitleService.techtitleForPage();
        return getDataTable(list);
    }

    @PostMapping("/userstatusForPage")
    @ResponseBody
    public TableDataInfo userstatusForPage()
    {
        startPage1("userstatusid");
        List<PzUserstatus> list = userstatusService.findUserstatusAll();
        return getDataTable(list);
    }

    @PostMapping("/postForPage")
    @ResponseBody
    public TableDataInfo postForPage()
    {
        startPage1("postid");
        List<PzPost> list = postService.selectAll();
        return getDataTable(list);
    }

    @PostMapping("/usergroupForPage")
    @ResponseBody
    public TableDataInfo usergroupForPage()
    {
        startPage1("usergroupid");
        List<PzUsergroup> list = usergroupService.findUsergroupAll();
        return getDataTable(list);
    }

    @PostMapping("/headshipForPage")
    @ResponseBody
    public TableDataInfo headshipForPage()
    {
        startPage1("headshipid");
        List<PzHeadship> list = headshipService.selectAll();
        return getDataTable(list);
    }

    @PostMapping("/worktypeForPage")
    @ResponseBody
    public TableDataInfo worktypeForPage()
    {
        startPage1("worktypeid");
        List<PzWorktype> list = worktypeService.selectAll();
        return getDataTable(list);
    }

    /**
     * 新增职称
     */
    @GetMapping("/addTechtitle")
    public String addTechtitle(ModelMap mmap)
    {
        return  "system/techtitle/addTechtitle";
    }

    /**
     * 新增保存职称
     */
    @Log(title = "职称管理", businessType = BusinessType.INSERT)
    @PostMapping("/addTechtitle")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addTechtitleSave(PzTechtitle techtitle)
    {

        return toAjax(techtitleService.insertTechtitle(techtitle));
    }

    /**
     * 校验职称维护是否重复
     */
    @PostMapping("/checkTechtitlenameUnique")
    @ResponseBody
    public String checkTechtitlenameUnique(String techtitlename)
    {
        return techtitleService.checkTechtitlenameUnique(techtitlename);
    }

    /**
     * 修改职称维护
     */
    @GetMapping("/editTechtitle/{techtitleid}")
    public String editTechtitle(@PathVariable("techtitleid") Integer techtitleid, ModelMap mmap)
    {
        mmap.put("techtitle", techtitleService.findTechtitleById(techtitleid));
        return "system/techtitle/editTechtitle";
    }

    /**
     * 修改保存职称维护
     */
    @Log(title = "职称管理", businessType = BusinessType.UPDATE)
    @PostMapping("/editTechtitle")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editTechtitleSave(PzTechtitle techtitle)
    {
        return toAjax(techtitleService.editTechtitleById(techtitle));
    }

    @Log(title = "职称管理", businessType = BusinessType.DELETE)
    @PostMapping("/delTechtitle")
    @ResponseBody
    public AjaxResult delTechtitle(String ids)
    {
        try
        {
            return toAjax(techtitleService.delTechtitleById(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }



    /**
     * 新增职务
     */
    @GetMapping("/addHeadship")
    public String addHeadship(ModelMap mmap)
    {
        return  "system/headship/addHeadship";
    }

    /**
     * 新增保存职务
     */
    @Log(title = "职务管理", businessType = BusinessType.INSERT)
    @PostMapping("/addHeadship")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addHeadship(PzHeadship headship)
    {

        return toAjax(headshipService.insertHeadship(headship));
    }

    /**
     * 校验职务维护是否重复
     */
    @PostMapping("/checkHeadshipnameUnique")
    @ResponseBody
    public String checkHeadshipnameUnique(String headshipname)
    {
        return headshipService.checkHeadshipnameUnique(headshipname);
    }

    /**
     * 修改职务维护
     */
    @GetMapping("/editHeadship/{headshipid}")
    public String editHeadship(@PathVariable("headshipid") Integer headshipid, ModelMap mmap)
    {
        mmap.put("headship", headshipService.findHeadshipById(headshipid));
        return "system/headship/editHeadship";
    }

    /**
     * 修改保存职务维护
     */
    @Log(title = "职务管理", businessType = BusinessType.UPDATE)
    @PostMapping("/editHeadship")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editHeadship(PzHeadship headship)
    {
        return toAjax(headshipService.editHeadshipById(headship));
    }

    @Log(title = "职务管理", businessType = BusinessType.DELETE)
    @PostMapping("/delHeadship")
    @ResponseBody
    public AjaxResult delHeadship(String ids)
    {
        try
        {
            return toAjax(headshipService.delHeadshipById(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }






    /**
     * 新增用工情况
     */
    @GetMapping("/addUserstatus")
    public String addUserstatus()
    {
        return  "system/user/addUserstatus";
    }

    /**
     * 新增保存用工情况
     */
    @Log(title = "用工情况管理", businessType = BusinessType.INSERT)
    @PostMapping("/addUserstatus")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addUserstatus(PzUserstatus userstatus)
    {

        return toAjax(userstatusService.addUserstatus(userstatus));
    }

    /**
     * 校验职务维护是否重复
     */
    @PostMapping("/checkUserstatusnameUnique")
    @ResponseBody
    public String checkUserstatusnameUnique(String userstatusname)
    {
        return userstatusService.findUserstatusByName(userstatusname);
    }

    /**
     * 修改用工情况
     */
    @GetMapping("/editUserstatus/{statusid}")
    public String editUserstatus(@PathVariable("statusid") Integer statusid, ModelMap mmap)
    {
        mmap.put("userstatus", userstatusService.findUserstatusById(statusid));
        return "system/user/editUserstatus";
    }

    /**
     * 修改保存用工情况
     */
    @Log(title = "用工情况管理", businessType = BusinessType.UPDATE)
    @PostMapping("/editUserstatus")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editUserstatus(PzUserstatus userstatus)
    {
        return toAjax(userstatusService.updataByUserstatusById(userstatus));
    }

    @Log(title = "用工情况管理", businessType = BusinessType.DELETE)
    @PostMapping("/delStatus")
    @ResponseBody
    public AjaxResult delStatus(String ids)
    {
        try
        {
            return toAjax(userstatusService.deluserstatusById(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }





    /**
     * 新增岗位
     */
    @GetMapping("/addPost")
    public String addPost()
    {
        return  "system/post/addPost";
    }

    /**
     * 新增保存岗位
     */
    @Log(title = "岗位管理", businessType = BusinessType.INSERT)
    @PostMapping("/addPost")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addPost(PzPost post)
    {

        return toAjax(postService.addPost(post));
    }

    /**
     * 校验岗位是否重复
     */
    @PostMapping("/checkpostnameUnique")
    @ResponseBody
    public String checkpostnameUnique(String postname)
    {
        return postService.selectByName(postname);
    }

    /**
     * 修改岗位
     */
    @GetMapping("/editPost/{postid}")
    public String editPost(@PathVariable("postid") Integer postid, ModelMap mmap)
    {
        mmap.put("post", postService.selectById(postid));
        return "system/post/editPost";
    }

    /**
     * 修改保存岗位
     */
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/editPost")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editPost(PzPost post)
    {
        return toAjax(postService.editPostById(post));
    }

    @Log(title = "岗位管理", businessType = BusinessType.DELETE)
    @PostMapping("/delPost")
    @ResponseBody
    public AjaxResult delPost(String ids)
    {
        try
        {
            return toAjax(postService.delById(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }








    /**
     * 新增班组
     */
    @GetMapping("/addUsergroup")
    public String addUsergroup()
    {
        return  "system/user/addUsergroup";
    }

    /**
     * 新增保存班组
     */
    @Log(title = "班组管理", businessType = BusinessType.INSERT)
    @PostMapping("/addUsergroup")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addUsergroup(PzUsergroup usergroup)
    {

        return toAjax(usergroupService.addUsergroup(usergroup));
    }

    /**
     * 校验班组是否重复
     */
    @PostMapping("/checkUsergroupnameUnique")
    @ResponseBody
    public String checkUsergroupnameUnique(String usergroupname)
    {
        return usergroupService.findUsergroupByName(usergroupname);
    }

    /**
     * 修改班组
     */
    @GetMapping("/editUsergroup/{usergroupid}")
    public String editUsergroup(@PathVariable("usergroupid") Integer usergroupid, ModelMap mmap)
    {
        mmap.put("usergroup", usergroupService.findUsergroupById(usergroupid));
        return "system/user/editUsergroup";
    }

    /**
     * 修改保存班组
     */
    @Log(title = "班组管理", businessType = BusinessType.UPDATE)
    @PostMapping("/editUsergroup")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editUsergroup(PzUsergroup usergroup)
    {
        return toAjax(usergroupService.updataByUserstatusById(usergroup));
    }

    @Log(title = "班组管理", businessType = BusinessType.DELETE)
    @PostMapping("/delUsergroup")
    @ResponseBody
    public AjaxResult delUsergroup(String ids)
    {
        try
        {
            return toAjax(usergroupService.deUsergroupById(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }




    /**
     * 新增工种
     */
    @GetMapping("/addWorktype")
    public String addWorktype()
    {
        return  "system/worktype/addWorktype";
    }

    /**
     * 新增保存工种
     */
    @Log(title = "工种管理", businessType = BusinessType.INSERT)
    @PostMapping("/addWorktype")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addWorktype(PzWorktype worktype)
    {

        return toAjax(worktypeService.addWorktype(worktype));
    }

    /**
     * 校验工种是否重复
     */
    @PostMapping("/checkWorktypenameUnique")
    @ResponseBody
    public String checkWorktypenameUnique(String worktypename)
    {
        return worktypeService.selectByName(worktypename);
    }

    /**
     * 修改工种
     */
    @GetMapping("/editWorktype/{worktypeid}")
    public String editWorktype(@PathVariable("worktypeid") Integer worktypeid, ModelMap mmap)
    {
        mmap.put("worktype", worktypeService.selectById(worktypeid));
        return "system/worktype/editWorktype";
    }

    /**
     * 修改保存工种
     */
    @Log(title = "工种管理", businessType = BusinessType.UPDATE)
    @PostMapping("/editWorktype")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editWorktype(PzWorktype worktype)
    {
        return toAjax(worktypeService.editWorktypeById(worktype));
    }

    @Log(title = "工种管理", businessType = BusinessType.DELETE)
    @PostMapping("/delWorktype")
    @ResponseBody
    public AjaxResult delWorktype(String ids)
    {
        try
        {
            return toAjax(worktypeService.delById(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }


    /**
     * 高等级角色维护表
     * @param
     * @return
     */
    @PostMapping("/highRolePage")
    @ResponseBody
    public TableDataInfo highRolePage(Integer rightgroupid)
    {
        startPage1("u.userid");
        if(rightgroupid == null){
            rightgroupid = 0;
        }
        List<PzUser> list = userService.findHighRole(rightgroupid);
        return getDataTable(list);
    }



}