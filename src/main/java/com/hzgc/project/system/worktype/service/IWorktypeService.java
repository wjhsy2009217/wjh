package com.hzgc.project.system.worktype.service;


import com.hzgc.project.system.worktype.domain.PzWorktype;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWorktypeService{

    List<PzWorktype> selectAll();

    PzWorktype selectById(int worktypeid);

    String selectByName(String worktypename);

    int addWorktype(PzWorktype worktype);

    int editWorktypeById(PzWorktype worktype);

    int delById(String worktypeid);

}
