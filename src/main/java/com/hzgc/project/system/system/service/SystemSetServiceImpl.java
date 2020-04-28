package com.hzgc.project.system.system.service;
import com.hzgc.project.system.system.domain.PzSystemSet;
import com.hzgc.project.system.system.mapper.PzSystemSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemSetServiceImpl implements ISystemSetService {

   @Autowired
    private PzSystemSetMapper systemSetMapper;

    @Override
    public PzSystemSet findBySystemId(Integer id) {
        return systemSetMapper.findBySystemId(id);
    }

    @Override
    public int updateVariablecharById(Integer id, String variablechar) {

        return  systemSetMapper.updateVariablecharById(id,variablechar);
    }


}
