package com.hzgc.framework.shiro.service;

import com.hzgc.project.system.user.domain.PzUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.hzgc.common.constant.Constants;
import com.hzgc.common.constant.ShiroConstants;
import com.hzgc.common.constant.UserConstants;
import com.hzgc.common.exception.user.CaptchaException;
import com.hzgc.common.exception.user.UserBlockedException;
import com.hzgc.common.exception.user.UserDeleteException;
import com.hzgc.common.exception.user.UserNotExistsException;
import com.hzgc.common.exception.user.UserPasswordNotMatchException;
import com.hzgc.common.utils.DateUtils;
import com.hzgc.common.utils.MessageUtils;
import com.hzgc.common.utils.ServletUtils;
import com.hzgc.common.utils.security.ShiroUtils;
import com.hzgc.framework.manager.AsyncManager;
import com.hzgc.framework.manager.factory.AsyncFactory;
import com.hzgc.project.system.user.domain.User;
import com.hzgc.project.system.user.domain.UserStatus;
import com.hzgc.project.system.user.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 登录校验方法
 * 
 * @author zyD
 */
@Component
public class LoginService
{
    @Autowired
    private PasswordService passwordService;

    @Autowired
    private IUserService userService;

    /*@Autowired
    private */

    /**
     * 登录
     */
    public User login(String username, String password)
    {
        // 验证码校验
        if (!StringUtils.isEmpty(ServletUtils.getRequest().getAttribute(ShiroConstants.CURRENT_CAPTCHA)))
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
            throw new CaptchaException();
        }
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("not.null")));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }

        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }

        // 查询用户信息
        User user = userService.selectUserByLoginName(username);

        if (user == null && maybeMobilePhoneNumber(username))
        {
            user = userService.selectUserByPhoneNumber(username);
        }

        if (user == null && maybeEmail(username))
        {
            user = userService.selectUserByEmail(username);
        }

        if (user == null)
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.not.exists")));
            throw new UserNotExistsException();
        }
        
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag()))
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.delete")));
            throw new UserDeleteException();
        }
        
        if (UserStatus.DISABLE.getCode().equals(user.getStatus()))
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.blocked", user.getRemark())));
            throw new UserBlockedException(user.getRemark());
        }

        passwordService.validate(user, password);

        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        recordLoginInfo(user);
        return user;
    }

    private boolean maybeEmail(String username)
    {
        if (!username.matches(UserConstants.EMAIL_PATTERN))
        {
            return false;
        }
        return true;
    }

    private boolean maybeMobilePhoneNumber(String username)
    {
        if (!username.matches(UserConstants.MOBILE_PHONE_NUMBER_PATTERN))
        {
            return false;
        }
        return true;
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(User user)
    {
        user.setLoginIp(ShiroUtils.getIp());
        user.setLoginDate(DateUtils.getNowDate());
        userService.updateUserInfo(user);
    }
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    /*public String dologin(HttpSession session, String username, String password){
        PzUserInfo queryUsernameForLogin = userInfoService.queryUsernameForLogin(username);

        if(queryUsernameForLogin != null){
            PzUserInfo user = userInfoService.login(username,password);
            String lastLoginTime = "";
            if(user.getLoginerror() == 0){
                Object lastLoginTimes = session.getAttribute("lastLoginTime_"+username);
                if(lastLoginTimes==null){
                    Date date = new Date(System.currentTimeMillis());
                    lastLoginTime = com.hzgc.common.utils.StringUtils.setDateFormate(date);
                    //记录最后一次登陆时间
                    session.setAttribute("lastLoginTime_"+username, lastLoginTime);//把最后一次登录时间放到session中
                }else{
                    lastLoginTime=(String)lastLoginTimes;
                }
                session.setAttribute("user", user);//把当前登录用户信息放到session
                session.setMaxInactiveInterval(60*60*12);
                logger.info("登陆成功：当前登录用户名为"+username);
                return "ok";
            }
            else{

                logger.info("密码错误！");
                return user.getLoginerror().toString();
            }
        } else {
            logger.info("该用户不存在！");
            return "noUser";
        }
    }*/
}
