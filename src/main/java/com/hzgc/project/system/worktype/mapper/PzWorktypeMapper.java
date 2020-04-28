package com.hzgc.project.system.worktype.mapper;

import com.hzgc.project.system.worktype.domain.PzWorktype;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzWorktypeMapper {
    List<PzWorktype> selectAll();

    PzWorktype selectById(int worktypeid);

    PzWorktype selectByName(String worktypename);

    int addWorktype(PzWorktype worktype);

    int editWorktypeById(PzWorktype worktype);

    int delById(Long[] worktypeid);
}