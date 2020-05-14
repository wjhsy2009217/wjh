package com.hzgc.project.system.user.service;

import java.util.ArrayList;
import java.util.List;

import com.hzgc.common.utils.Md5Utils;
import com.hzgc.project.system.user.domain.PzUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hzgc.common.constant.UserConstants;
import com.hzgc.common.utils.StringUtils;
import com.hzgc.project.system.post.domain.Post;
import com.hzgc.project.system.post.mapper.PostMapper;
import com.hzgc.project.system.role.domain.Role;
import com.hzgc.project.system.role.mapper.RoleMapper;
import com.hzgc.project.system.user.mapper.UserMapper;

/**
 * 用户 业务层处理
 * 
 * @author zyD
 */
@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PostMapper postMapper;



       /**
     * 查询用户所属角色组
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public String selectUserRoleGroup(Long userId)
    {
        List<Role> list = roleMapper.selectRolesByUserId(userId);
        StringBuffer idsStr = new StringBuffer();
        for (Role role : list)
        {
            idsStr.append(role.getRoleName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString()))
        {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }

    /**
     * 查询用户所属岗位组
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public String selectUserPostGroup(Long userId)
    {
        List<Post> list = postMapper.selectPostsByUserId(userId);
        StringBuffer idsStr = new StringBuffer();
        for (Post post : list)
        {
            idsStr.append(post.getPostName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString()))
        {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }

    @Override
    public List<PzUser> userRestorePage(String loginName,String kind,String beginTime ,String endTime ,String depa,String sex,String poli,
                                        String post,String edu,String usernum,int status) {
        return userMapper.userRestorePage(loginName,kind,beginTime ,endTime ,depa,sex,poli,
                post,edu,usernum,status);
    }

    @Override
    public String checkPwdUnique(long userid, String pwd) {
        pwd = Md5Utils.hash(pwd);
        PzUser user = userMapper.checkPwdUnique(userid,pwd);
        if (StringUtils.isNotNull(user))
        {
            return UserConstants.USER_PASSWORD_ERROR;
        }
        return UserConstants.USER_PASSWORD_NOT_ERROR;
    }

    @Override
    public void editUserPwd(long userid, String pwd) {
        pwd = Md5Utils.hash(pwd);
        userMapper.editUserPwd(userid,pwd);
    }

    @Override
    public List<PzUser> userMaintainPage(String loginName,String kind,String beginTime ,String endTime ,String depa,
                                         String post,String phone,String usernum,String rightgroup,int status) {
        return userMapper.userMaintainPage(loginName,kind,beginTime ,endTime ,depa,rightgroup,
                post,phone,usernum,status);
    }

    @Override
    public int deleteUserMaintainByIds(String ids, int status) throws Exception {
        return userMapper.deleteUserMaintainByIds(ids,status);
    }

    @Override
    public List<PzUser> findHighRole(int rightgroupid) {
        return userMapper.findHighRole(rightgroupid);
    }


}
