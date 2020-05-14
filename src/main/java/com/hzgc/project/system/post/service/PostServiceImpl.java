package com.hzgc.project.system.post.service;

import java.util.List;

import com.hzgc.project.system.post.mapper.PzPostMapper;
import com.hzgc.project.system.user.domain.PzPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hzgc.common.constant.UserConstants;
import com.hzgc.common.support.Convert;
import com.hzgc.common.utils.StringUtils;
import com.hzgc.project.system.post.domain.Post;
import com.hzgc.project.system.post.mapper.PostMapper;
import com.hzgc.project.system.user.mapper.UserPostMapper;

/**
 * 岗位信息 服务层处理
 * 
 * @author zyD
 */
@Service
public class PostServiceImpl implements IPostService
{

    @Autowired
    private PzPostMapper pzPostMapper;


    @Override
    public List<PzPost> selectAll() {
        return pzPostMapper.selectAll();
    }

    @Override
    public PzPost selectById(int postid) {
        return pzPostMapper.selectById(postid);
    }

    @Override
    public String selectByName(String postname) {
        PzPost pp = pzPostMapper.selectByName(postname);
        if(pp==null){
            return "0";
        }
        return "1";
    }

    @Override
    public int addPost(PzPost pzPost) {
        return pzPostMapper.addPost(pzPost);
    }

    @Override
    public int editPostById(PzPost pzPost) {
        return pzPostMapper.editPostById(pzPost);
    }

    @Override
    public int delById(String postid) {
        Long[] ids = Convert.toLongArray(postid);
        return pzPostMapper.delById(ids);
    }
}
