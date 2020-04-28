package com.hzgc.project.system.user.mapper;

import com.hzgc.project.system.user.domain.PzUserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PzUserInfoMapper {
    PzUserInfo selectByUserId(@Param("userid") Long userid);

    void updateByUserId(@Param("userid") long userid, @Param("operatortheme") String operatortheme,
                        @Param("operatorlan") String operatorlan, @Param("operatorskin") String operatorskin, @Param("loginerror") Integer loginerror);

    PzUserInfo login(@Param("username") String username, @Param("password") String password);

    PzUserInfo queryUsernameForLogin(@Param("username") String username);

    void updateLoginError(@Param("count") int count, @Param("username") String username);
}