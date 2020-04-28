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
    /**
     * 根据条件分页查询用户对象
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<User> selectUserList(User user);

    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return 用户对象信息
     */
    public User selectUserByLoginName(String userName);

    /**
     * 通过手机号码查询用户
     * 
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    public User selectUserByPhoneNumber(String phoneNumber);

    /**
     * 通过邮箱查询用户
     * 
     * @param email 邮箱
     * @return 用户对象信息
     */
    public User selectUserByEmail(String email);

    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public User selectUserById(Long userId);

    /**
     * 通过用户ID删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteUserByIds(String ids) throws Exception;

    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 修改用户详细信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserInfo(User user);

    /**
     * 修改用户密码信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int resetUserPwd(User user);

    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 登录名称
     * @return 结果
     */
    public String checkLoginNameUnique(String loginName);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkPhoneUnique(User user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkEmailUnique(User user);

    /**
     * 根据用户ID查询用户所属角色组
     * 
     * @param userId 用户ID
     * @return 结果
     */
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
