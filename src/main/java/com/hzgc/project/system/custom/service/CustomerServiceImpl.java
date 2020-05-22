package com.hzgc.project.system.custom.service;

import com.hzgc.common.support.Convert;
import com.hzgc.project.system.custom.domain.PzCustomer;
import com.hzgc.project.system.custom.domain.PzOrgan;
import com.hzgc.project.system.custom.mapper.PzCustomerMapper;
import com.hzgc.project.system.custom.mapper.PzOrganMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private PzCustomerMapper customerMapper;

    @Override
    public List<PzCustomer> selectAll() {
        return customerMapper.selectAll();
    }

    @Override
    public PzCustomer findById(int id) {
        return customerMapper.selectById(id);
    }

    @Override
    public int add(PzCustomer customer) {
        return customerMapper.add(customer);
    }

    @Override
    public int edit(PzCustomer customer) {
        return customerMapper.edit(customer);
    }

    @Override
    public int del(String id) {
        Long[] ids = Convert.toLongArray(id);
        return customerMapper.del(ids);
    }
}
