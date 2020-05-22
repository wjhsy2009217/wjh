package com.hzgc.project.system.custom.mapper;

import com.hzgc.project.system.custom.domain.PzOrgan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzOrganMapper {

    List<PzOrgan> selectAll();

    PzOrgan selectById(Long id);

    PzOrgan selectByName(String organname);

    int edit(PzOrgan organ);

    int add(PzOrgan organ);

    int del(Long[] id);
}