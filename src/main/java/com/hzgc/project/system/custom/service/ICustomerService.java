package com.hzgc.project.system.custom.service;


import com.hzgc.project.system.custom.domain.PzCustomer;
import com.hzgc.project.system.custom.domain.PzOrgan;

import java.util.List;

public interface ICustomerService {

    List<PzCustomer> selectAll();

    PzCustomer findById(int id);

    int add(PzCustomer organ);

    int edit(PzCustomer organ);

    int del(String id);

}
