package com.hzgc.project.system.user.controller;

import javax.security.auth.login.AccountExpiredException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzgc.project.system.user.domain.PzUser;
import com.hzgc.project.system.user.domain.PzUserInfo;
import com.hzgc.project.system.user.domain.User;
import com.hzgc.project.system.user.service.IUserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hzgc.common.utils.ServletUtils;
import com.hzgc.common.utils.StringUtils;
import com.hzgc.framework.web.controller.BaseController;
import com.hzgc.framework.web.domain.AjaxResult;

import java.util.Date;

/**
 * 登录验证captchaEnabled
 * 
 * @author zyD
 */
@Controller
public class LoginController extends BaseController
{
    @Autowired
    private IUserInfoService userInfoService;
    /*@GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return "login";
    }*/

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe, HttpSession session)
    {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            PzUser user = new PzUser();
            session.setAttribute("user", user);
            return success();
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "/error/unauth";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    /*
     * （ajax验证）用户登录验证用户名和密码
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value="/doLogin",method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult login(String username, String password, Boolean rememberMe, HttpSession session) {
        PzUserInfo queryUsernameForLogin = userInfoService.queryUsernameForLogin(username);

        if(queryUsernameForLogin != null){
            PzUserInfo user = userInfoService.login(username,password);
            String lastLoginTime = "";
            if(user.getLoginerror() == 0){
                Object lastLoginTimes = session.getAttribute("lastLoginTime_"+username);
                if(lastLoginTimes==null){
                    Date date = new Date(System.currentTimeMillis());
                    lastLoginTime = StringUtils.setDateFormate(date);
                    //记录最后一次登陆时间
                    session.setAttribute("lastLoginTime_"+username, lastLoginTime);//把最后一次登录时间放到session中
                }else{
                    lastLoginTime=(String)lastLoginTimes;
                }
                session.setAttribute("user", user);//把当前登录用户信息放到session
                session.setMaxInactiveInterval(60*60*12);
                System.out.println("登陆成功：当前登录用户名为"+username);
                return success();
            }
            else{

                String msg = "密码错误！";
                return error(msg);
            }
        } else {
            String msg ="该用户不存在！";
            return error(msg);
        }

    }
}
