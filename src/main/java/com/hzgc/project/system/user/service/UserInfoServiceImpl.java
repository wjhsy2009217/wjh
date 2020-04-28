package com.hzgc.project.system.user.service;

import com.hzgc.common.utils.Md5Utils;
import com.hzgc.project.system.user.domain.PzUserInfo;
import com.hzgc.project.system.user.mapper.PzUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private PzUserInfoMapper userInfoDao;

    @Override
    public PzUserInfo selectByUserId(Long userid) {
        return userInfoDao.selectByUserId(userid);
    }

    @Override
    public void updateByUserId(long userid,String operatortheme,String operatorlan,String operatorskin,Integer loginerror) {
       userInfoDao.updateByUserId(userid,operatortheme,operatorlan,operatorskin,loginerror);
    }
    @Override
    public PzUserInfo login(String username, String password){
        PzUserInfo PzUserInfo = userInfoDao.queryUsernameForLogin(username);
        if(PzUserInfo!=null){
            String pwd = PzUserInfo.getLoginpassword();
            //重新计算MD5值做数据库密码匹配
            String passwordMd5 = Md5Utils.hash(password);
            if(pwd.equals(passwordMd5)){
                userInfoDao.updateLoginError(0,username);
            } else {
                PzUserInfo user1 = userInfoDao.queryUsernameForLogin(username);
                userInfoDao.updateLoginError(PzUserInfo.getLoginerror()+1,username);
            }
        }
        PzUserInfo = userInfoDao.queryUsernameForLogin(username);
        return PzUserInfo;

    }
    @Override
    public PzUserInfo queryUsernameForLogin(String username){
        PzUserInfo user = userInfoDao.queryUsernameForLogin(username);
        return user;
    }

    @Override
    public void updateLoginError(int count,String username){
        userInfoDao.updateLoginError(count,username);
    }
}
