package com.hzgc.project.system.post.mapper;

import com.hzgc.project.system.post.domain.Post;
import com.hzgc.project.system.user.domain.PzPost;

import java.util.List;

public interface PzPostMapper
{

    /**
     * 岗位查询
     * @return
     */
    List<PzPost> selectAll();

    PzPost selectById(int postid);

    PzPost selectByName(String postname);

    int addPost(PzPost pzPost);

    int editPostById(PzPost pzPost);

    int delById(Long [] postid);

}
