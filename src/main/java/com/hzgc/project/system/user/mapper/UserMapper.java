package com.hzgc.project.system.user.mapper;

import com.hzgc.project.system.user.domain.PzUser;
import com.hzgc.project.system.user.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表 数据层
 * 
 * @author zyd
 */
public interface UserMapper
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
     */
    public int deleteUserByIds(Long[] ids);

    /**
     * 修改用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 新增用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 登录名称
     * @return 结果
     */
    public int checkLoginNameUnique(String loginName);

    /**
     * 校验手机号码是否唯一
     *
     * @param phonenumber 手机号码
     * @return 结果
     */
    public User checkPhoneUnique(String phonenumber);

    /**
     * 校验email是否唯一
     *
     * @param email 用户邮箱
     * @return 结果
     */
    public User checkEmailUnique(String email);

    /**
     * 查询恢复人员
     * @return
     */
    List<PzUser> userRestorePage(@Param("loginname") String loginname, @Param("kind")String kind, @Param("beginTime")String beginTime , @Param("endTime")String endTime , @Param("depa")String depa, @Param("sex")String sex,@Param("poli") String poli,
                                 @Param("post")String post, @Param("edu")String edu, @Param("usernum")String usernum,@Param("status")Integer status);

    PzUser checkPwdUnique(@Param("userid") long userid, @Param("old")String old);

    void editUserPwd(@Param("userid") long userid, @Param("pwd")String pwd);

    List<PzUser> userMaintainPage(@Param("loginname") String loginname, @Param("kind")String kind, @Param("beginTime")String beginTime , @Param("endTime")String endTime , @Param("depa")String depa, @Param("post")String post,@Param("phone") String phone,
                                 @Param("usernum")String usernum, @Param("rightgroup")String rightgroup, @Param("status")Integer status);

    int deleteUserMaintainByIds(@Param("ids")String ids,@Param("status") int status);

    List<PzUser> findHighRole(@Param("rightgroupid")int rightgroupid);
}
