package com.hzgc.project.system.user.domain;

import java.util.Date;

public class PzUserstatus {
    private Integer userstatusid;

    private String userstatusname;

    private String statusFlag;

    private Date createtime;

    private Date modifytime;

    public Integer getUserstatusid() {
        return userstatusid;
    }

    public void setUserstatusid(Integer userstatusid) {
        this.userstatusid = userstatusid;
    }

    public String getUserstatusname() {
        return userstatusname;
    }

    public void setUserstatusname(String userstatusname) {
        this.userstatusname = userstatusname == null ? null : userstatusname.trim();
    }

    public String getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag == null ? null : statusFlag.trim();
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