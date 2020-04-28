package com.hzgc.project.system.headship.domain;

import java.util.Date;

public class PzHeadship {
    private Integer headshipid;

    private String headshipname;

    private Date createtime;

    private Date modifytime;

    public Integer getHeadshipid() {
        return headshipid;
    }

    public void setHeadshipid(Integer headshipid) {
        this.headshipid = headshipid;
    }

    public String getHeadshipname() {
        return headshipname;
    }

    public void setHeadshipname(String headshipname) {
        this.headshipname = headshipname == null ? null : headshipname.trim();
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