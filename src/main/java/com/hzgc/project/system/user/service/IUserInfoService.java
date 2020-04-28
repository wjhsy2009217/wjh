package com.hzgc.project.system.user.service;

import com.hzgc.project.system.user.domain.PzUserInfo;

public interface IUserInfoService {
    PzUserInfo selectByUserId(Long userid);

    void updateByUserId(long userid, String operatortheme, String operatorlan, String operatorskin, Integer loginerror);

    PzUserInfo login(String username, String password);

    PzUserInfo queryUsernameForLogin(String username);

    void updateLoginError(int count, String username);
}
