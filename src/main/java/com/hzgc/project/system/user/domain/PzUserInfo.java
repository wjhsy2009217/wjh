package com.hzgc.project.system.user.domain;

import java.io.Serializable;
import java.util.Date;

public class PzUserInfo  implements Serializable {
    private Long userid;

    private Integer worktypeid;

    private Integer nationid;

    private Integer headshipid;

    private Integer techtitleid;

    private Integer educationid;

    private Integer politicalstateid;

    private Integer postid;

    private String ismarry;

    private String nativeplace;

    private String householdplace;

    private Date birthday;

    private String email;

    private String address;

    private String phone;

    private String postcode;

    private Date workbegin;

    private String profession;

    private String college;

    private Date collegeenddate;

    private Date contractbegindate;

    private Date contractenddate;

    private Date registertime;

    private Date canceltime;

    private String operatortheme;

    private String operatorlan;

    private String operatorskin;

    private String loginaccount;

    private String loginpassword;

    private String loginmode;

    private Integer loginerror;

    private Date lastlogintime;

    private Date createtime;

    private Date modifytime;

    private PzUser pzUser;

    public void setPzUser(PzUser pzUser) {
        this.pzUser = pzUser;
    }

    public PzUser getPzUser() {
        return pzUser;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getWorktypeid() {
        return worktypeid;
    }

    public void setWorktypeid(Integer worktypeid) {
        this.worktypeid = worktypeid;
    }

    public Integer getNationid() {
        return nationid;
    }

    public void setNationid(Integer nationid) {
        this.nationid = nationid;
    }

    public Integer getHeadshipid() {
        return headshipid;
    }

    public void setHeadshipid(Integer headshipid) {
        this.headshipid = headshipid;
    }

    public Integer getTechtitleid() {
        return techtitleid;
    }

    public void setTechtitleid(Integer techtitleid) {
        this.techtitleid = techtitleid;
    }

    public Integer getEducationid() {
        return educationid;
    }

    public void setEducationid(Integer educationid) {
        this.educationid = educationid;
    }

    public Integer getPoliticalstateid() {
        return politicalstateid;
    }

    public void setPoliticalstateid(Integer politicalstateid) {
        this.politicalstateid = politicalstateid;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getIsmarry() {
        return ismarry;
    }

    public void setIsmarry(String ismarry) {
        this.ismarry = ismarry == null ? null : ismarry.trim();
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace == null ? null : nativeplace.trim();
    }

    public String getHouseholdplace() {
        return householdplace;
    }

    public void setHouseholdplace(String householdplace) {
        this.householdplace = householdplace == null ? null : householdplace.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public Date getWorkbegin() {
        return workbegin;
    }

    public void setWorkbegin(Date workbegin) {
        this.workbegin = workbegin;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public Date getCollegeenddate() {
        return collegeenddate;
    }

    public void setCollegeenddate(Date collegeenddate) {
        this.collegeenddate = collegeenddate;
    }

    public Date getContractbegindate() {
        return contractbegindate;
    }

    public void setContractbegindate(Date contractbegindate) {
        this.contractbegindate = contractbegindate;
    }

    public Date getContractenddate() {
        return contractenddate;
    }

    public void setContractenddate(Date contractenddate) {
        this.contractenddate = contractenddate;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public Date getCanceltime() {
        return canceltime;
    }

    public void setCanceltime(Date canceltime) {
        this.canceltime = canceltime;
    }

    public String getOperatortheme() {
        return operatortheme;
    }

    public void setOperatortheme(String operatortheme) {
        this.operatortheme = operatortheme == null ? null : operatortheme.trim();
    }

    public String getOperatorlan() {
        return operatorlan;
    }

    public void setOperatorlan(String operatorlan) {
        this.operatorlan = operatorlan == null ? null : operatorlan.trim();
    }

    public String getOperatorskin() {
        return operatorskin;
    }

    public void setOperatorskin(String operatorskin) {
        this.operatorskin = operatorskin == null ? null : operatorskin.trim();
    }

    public String getLoginaccount() {
        return loginaccount;
    }

    public void setLoginaccount(String loginaccount) {
        this.loginaccount = loginaccount == null ? null : loginaccount.trim();
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword == null ? null : loginpassword.trim();
    }

    public String getLoginmode() {
        return loginmode;
    }

    public void setLoginmode(String loginmode) {
        this.loginmode = loginmode == null ? null : loginmode.trim();
    }

    public Integer getLoginerror() {
        return loginerror;
    }

    public void setLoginerror(Integer loginerror) {
        this.loginerror = loginerror;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}