package com.hzgc.project.system.custom.service;


import com.hzgc.project.system.custom.domain.PzCustomer;
import com.hzgc.project.system.custom.domain.PzRightcustomer;

import java.util.List;

public interface IRightcustomerService {

    List<PzRightcustomer> selectAll();

    PzRightcustomer findById(int id);

    int add(PzRightcustomer rightcustomer);

    int edit(PzRightcustomer rightcustomer);

    int del(String id);

}
