package com.hzgc.project.system.user.domain;


import com.hzgc.project.system.department.domain.PzDepartment;
import com.hzgc.project.system.rightgroup.domain.PzRightgroup;

import java.io.Serializable;

public class PzUser implements Serializable {
    private Long userid;

    private String username;

    private Integer departid;

    private Integer userkindid;

    private Integer usergroupid;

    private Integer rightgroupid;

    private String usernum;

    private String handtel;

    private String identitycardno;

    private String useraccount;

    private String outid;

    private String sex;

    private Integer userstatus;

    private String photo;

    private PzUserInfo pzUserInfo;

    private PzDepartment pzDepartment;

    private PzEducation pzEducation;

    private PzPoliticalstate pzPoliticalstate;

    private PzPost pzPost;

    private PzUserKind pzUserKind;

    private PzRightgroup pzRightgroup;

    private PzUserstatus pzUserstatus;

    public Long getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public Integer getDepartid() {
        return departid;
    }

    public Integer getUserkindid() {
        return userkindid;
    }

    public Integer getUsergroupid() {
        return usergroupid;
    }

    public Integer getRightgroupid() {
        return rightgroupid;
    }

    public String getUsernum() {
        return usernum;
    }

    public String getHandtel() {
        return handtel;
    }

    public String getIdentitycardno() {
        return identitycardno;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public String getOutid() {
        return outid;
    }

    public String getSex() {
        return sex;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public String getPhoto() {
        return photo;
    }

    public PzUserInfo getPzUserInfo() {
        return pzUserInfo;
    }

    public PzDepartment getPzDepartment() {
        return pzDepartment;
    }

    public PzEducation getPzEducation() {
        return pzEducation;
    }

    public PzPoliticalstate getPzPoliticalstate() {
        return pzPoliticalstate;
    }

    public PzPost getPzPost() {
        return pzPost;
    }

    public PzUserKind getPzUserKind() {
        return pzUserKind;
    }

    public PzRightgroup getPzRightgroup() {
        return pzRightgroup;
    }

    public PzUserstatus getPzUserstatus() {
        return pzUserstatus;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDepartid(Integer departid) {
        this.departid = departid;
    }

    public void setUserkindid(Integer userkindid) {
        this.userkindid = userkindid;
    }

    public void setUsergroupid(Integer usergroupid) {
        this.usergroupid = usergroupid;
    }

    public void setRightgroupid(Integer rightgroupid) {
        this.rightgroupid = rightgroupid;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public void setHandtel(String handtel) {
        this.handtel = handtel;
    }

    public void setIdentitycardno(String identitycardno) {
        this.identitycardno = identitycardno;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public void setOutid(String outid) {
        this.outid = outid;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPzUserInfo(PzUserInfo pzUserInfo) {
        this.pzUserInfo = pzUserInfo;
    }

    public void setPzDepartment(PzDepartment pzDepartment) {
        this.pzDepartment = pzDepartment;
    }

    public void setPzEducation(PzEducation pzEducation) {
        this.pzEducation = pzEducation;
    }

    public void setPzPoliticalstate(PzPoliticalstate pzPoliticalstate) {
        this.pzPoliticalstate = pzPoliticalstate;
    }

    public void setPzPost(PzPost pzPost) {
        this.pzPost = pzPost;
    }

    public void setPzUserKind(PzUserKind pzUserKind) {
        this.pzUserKind = pzUserKind;
    }

    public void setPzRightgroup(PzRightgroup pzRightgroup) {
        this.pzRightgroup = pzRightgroup;
    }

    public void setPzUserstatus(PzUserstatus pzUserstatus) {
        this.pzUserstatus = pzUserstatus;
    }
}