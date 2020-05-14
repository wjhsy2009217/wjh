package com.hzgc.project.system.post.service;

import java.util.List;
import com.hzgc.project.system.post.domain.Post;
import com.hzgc.project.system.user.domain.PzPost;

/**
 * 岗位信息 服务层
 * 
 * @author zyd
 */
public interface IPostService
{
    /**
     * 查询所有岗位信息
     * @return
     */
    List<PzPost> selectAll();

    PzPost selectById(int postid);

    String selectByName(String postname);

    int addPost(PzPost pzPost);

    int editPostById(PzPost pzPost);

    int delById(String postid);
}
