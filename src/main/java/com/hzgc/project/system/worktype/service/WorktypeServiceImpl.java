package com.hzgc.project.system.worktype.service;

import com.hzgc.common.constant.UserConstants;
import com.hzgc.common.support.Convert;
import com.hzgc.common.utils.StringUtils;
import com.hzgc.common.utils.security.ShiroUtils;
import com.hzgc.project.system.post.domain.Post;
import com.hzgc.project.system.post.mapper.PostMapper;
import com.hzgc.project.system.post.mapper.PzPostMapper;
import com.hzgc.project.system.post.service.IPostService;
import com.hzgc.project.system.user.domain.PzPost;
import com.hzgc.project.system.user.mapper.UserPostMapper;
import com.hzgc.project.system.worktype.domain.PzWorktype;
import com.hzgc.project.system.worktype.mapper.PzWorktypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author zyD
 */
@Service
public class WorktypeServiceImpl implements IWorktypeService
{
    @Autowired
    private PzWorktypeMapper worktypeMapper;

    @Override
    public List<PzWorktype> selectAll() {
        return worktypeMapper.selectAll();
    }

    @Override
    public PzWorktype selectById(int worktypeid) {
        return worktypeMapper.selectById(worktypeid);
    }

    @Override
    public String selectByName(String worktypename) {
        PzWorktype pw = worktypeMapper.selectByName(worktypename);
        if(pw == null){
            return"0";
        }
        return "1";
    }

    @Override
    public int addWorktype(PzWorktype worktype) {
        return worktypeMapper.addWorktype(worktype);
    }

    @Override
    public int editWorktypeById(PzWorktype worktype) {
        return worktypeMapper.editWorktypeById(worktype);
    }

    @Override
    public int delById(String worktypeid) {
        Long[] ids = Convert.toLongArray(worktypeid);
        return worktypeMapper.delById(ids);
    }
}
