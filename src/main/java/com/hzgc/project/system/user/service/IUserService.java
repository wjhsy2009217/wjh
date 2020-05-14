package com.hzgc.project.system.user.service;

import com.hzgc.project.system.user.domain.PzUser;
import com.hzgc.project.system.user.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户 业务层
 * 
 * @author zYD
 */
public interface IUserService
{
    public String selectUserRoleGroup(Long userId);

    /**
     * 根据用户ID查询用户所属岗位组
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public String selectUserPostGroup(Long userId);

    /**
     * 查询人员回复表
     * @param loginName
     * @param kind
     * @param beginTime
     * @param endTime
     * @param depa
     * @param sex
     * @param poli
     * @param post
     * @param edu
     * @param usernum
     * @param status
     * @return
     */
    public List<PzUser> userRestorePage(String loginName,String kind,String beginTime ,String endTime ,String depa,String sex,String poli,
                                        String post,String edu,String usernum,int status);

    /**
     * 验证密码是否正确
     * @param id
     * @param pwd
     * @return
     */
    public String checkPwdUnique(long id,String pwd);

    /**
     * 修改密码
     * @param userid
     * @param pwd
     */
    void editUserPwd(long userid, String pwd);

    /**
     * 查询人员维护表
     * @param loginName
     * @param kind
     * @param beginTime
     * @param endTime
     * @param depa
     * @param post
     * @param phone
     * @param usernum
     * @param rightgroup
     * @param status
     * @return
     */
    public List<PzUser> userMaintainPage(String loginName,String kind,String beginTime ,String endTime ,String depa,
                                        String post,String phone,String usernum,String rightgroup,int status);

     /** @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteUserMaintainByIds(String ids,int status) throws Exception;

    List<PzUser> findHighRole(int rightgroupid);

}
