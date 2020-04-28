package com.hzgc.project.system.user.mapper;


import com.hzgc.project.system.user.domain.PzTechtitle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzTechtitleMapper {

    List<PzTechtitle> techtitleForPage();

    PzTechtitle checkTechtitlenameUnique(String old);

    int insertTechtitle(PzTechtitle techtitle);

    PzTechtitle findTechtitleById(int techtitleid);

    int editTechtitleById(PzTechtitle techtitle);

    int delTechtitleById(Long[] techtitleid);

}