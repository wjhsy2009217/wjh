package com.hzgc.project.system.headship.mapper;

import com.hzgc.project.system.headship.domain.PzHeadship;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzHeadshipMapper {
    List<PzHeadship> selectAll();

    PzHeadship checkHeadshipnameUnique(String old);

    int insertHeadship(PzHeadship headship);

    PzHeadship findHeadshipById(int headshipid);

    int editHeadshipById(PzHeadship headship);

    int delHeadshipById(Long[] headshipid);
}