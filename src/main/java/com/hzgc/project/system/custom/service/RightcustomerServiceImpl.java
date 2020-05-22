package com.hzgc.project.system.custom.service;

import com.hzgc.common.support.Convert;
import com.hzgc.project.system.custom.domain.PzCustomer;
import com.hzgc.project.system.custom.domain.PzRightcustomer;
import com.hzgc.project.system.custom.mapper.PzCustomerMapper;
import com.hzgc.project.system.custom.mapper.PzRightcustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightcustomerServiceImpl implements IRightcustomerService {

  @Autowired
  private PzRightcustomerMapper rightcustomerMapper;

    @Override
    public List<PzRightcustomer> selectAll() {
        return rightcustomerMapper.selectAll();
    }

    @Override
    public PzRightcustomer findById(int id) {
        return rightcustomerMapper.selectById(id);
    }

    @Override
    public int add(PzRightcustomer rightcustomer) {
        return rightcustomerMapper.add(rightcustomer);
    }

    @Override
    public int edit(PzRightcustomer rightcustomer) {
        return rightcustomerMapper.edit(rightcustomer);
    }

    @Override
    public int del(String id) {
        Long[] ids = Convert.toLongArray(id);
        return rightcustomerMapper.del(ids);
    }
}
