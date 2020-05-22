package com.hzgc.project.system.custom.service;

import com.hzgc.common.support.Convert;
import com.hzgc.project.system.custom.domain.PzOrgan;
import com.hzgc.project.system.custom.mapper.PzOrganMapper;
import com.hzgc.project.system.department.domain.PzDepartment;
import com.hzgc.project.system.department.mapper.PzDepartmentMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrganServiceImpl implements IOrganService {
    @Autowired
    private PzOrganMapper pzOrganMapper;

    @Override
    public List<PzOrgan> selectAll() {
        return pzOrganMapper.selectAll();
    }

    @Override
    public PzOrgan findById(Long id) {
        return pzOrganMapper.selectById(id);
    }

    @Override
    public int add(PzOrgan organ) {
        return pzOrganMapper.add(organ);
    }

    @Override
    public int edit(PzOrgan organ) {
        return pzOrganMapper.edit(organ);
    }

    @Override
    public int del(String id) {
        Long[] ids = Convert.toLongArray(id);
        return pzOrganMapper.del(ids);
    }
}
