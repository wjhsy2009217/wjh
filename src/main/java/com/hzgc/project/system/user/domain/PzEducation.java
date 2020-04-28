package com.hzgc.project.system.user.domain;

import java.util.Date;

public class PzEducation {
    private Integer educationid;

    private String educationname;

    private Date createtime;

    private Date modifytime;

    public Integer getEducationid() {
        return educationid;
    }

    public void setEducationid(Integer educationid) {
        this.educationid = educationid;
    }

    public String getEducationname() {
        return educationname;
    }

    public void setEducationname(String educationname) {
        this.educationname = educationname == null ? null : educationname.trim();
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