package com.hzgc.project.system.user.service;


import com.hzgc.project.system.user.domain.PzTechtitle;
import com.hzgc.project.system.user.domain.PzUserInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

public interface ITechtitleService {

    List<PzTechtitle> techtitleForPage();

    String checkTechtitlenameUnique(String old);

    int insertTechtitle(PzTechtitle techtitle);

    PzTechtitle findTechtitleById(int techtitleid);

    int editTechtitleById(PzTechtitle techtitle);

    int delTechtitleById(String techtitleid);
}
