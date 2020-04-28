package com.hzgc.project.system.user.controller;

import java.util.List;

import com.hzgc.project.system.project.domain.PzProject;
import com.hzgc.project.system.project.service.IProjectService;
import com.hzgc.project.system.user.domain.PzUser;
import com.hzgc.project.system.user.domain.PzUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.hzgc.framework.config.RuoYiConfig;
import com.hzgc.framework.web.controller.BaseController;
import com.hzgc.project.system.menu.domain.Menu;
import com.hzgc.project.system.menu.service.IMenuService;
import com.hzgc.project.system.user.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 首页 业务处理
 * 
 * @author zyd
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private RuoYiConfig ruoYiConfig;

    @Autowired
    private IProjectService projectService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
      User user = getUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        int id = 1;
        mmap.put("copyrightYear", ruoYiConfig.getCopyrightYear());
        mmap.put("pro",projectService.getProjectByUserid(id));
        mmap.put("pm",projectService.getProjectByUserid(id).get(0).getPzModulegroups());

        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", ruoYiConfig.getVersion());
        return "main";
    }

    // 系统介绍
    @PostMapping("/system/model")
    @ResponseBody
    public PzProject model(int id, HttpSession session)
    {
        PzUserInfo user = (PzUserInfo)session.getAttribute("user");
        int userid = user.getUserid().intValue();
        PzProject pro = projectService.getProjectById(id,userid);
        return pro;
    }
}
