package com.hzgc.project.system.custom.mapper;

import com.hzgc.project.system.custom.domain.PzRightcustomer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzRightcustomerMapper {
    List<PzRightcustomer> selectAll();

    PzRightcustomer selectById(int id);

    int edit(PzRightcustomer rightcustomer);

    int add(PzRightcustomer rightcustomer);

    int del(Long[] id);

}