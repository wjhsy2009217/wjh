package com.hzgc.project.system.project.mapper;


import com.hzgc.project.system.project.domain.PzProrgroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzProrgroupMapper {
    List<PzProrgroup> findById(int rightgroupid);

    int delById(int rightgroupid);

    int add(@Param("pros")List<PzProrgroup> pros);
}