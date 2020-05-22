package com.hzgc.project.system.custom.mapper;


import com.hzgc.project.system.custom.domain.PzCustomer;
import com.hzgc.project.system.custom.domain.PzOrgan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PzCustomerMapper {
    List<PzCustomer> selectAll();

    PzCustomer selectById(int id);

    PzCustomer selectByName(String customername );

    int edit(PzCustomer customer);

    int add(PzCustomer customer);

    int del(Long[] id);

}