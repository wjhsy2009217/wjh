package com.hzgc.project.system.user.domain;

import java.util.Date;

public class PzTechtitle {
    private Integer techtitleid;

    private String techtitlename;

    private String levelkind;

    private Date createtime;

    private Date modifytime;

    public Integer getTechtitleid() {
        return techtitleid;
    }

    public void setTechtitleid(Integer techtitleid) {
        this.techtitleid = techtitleid;
    }

    public String getTechtitlename() {
        return techtitlename;
    }

    public void setTechtitlename(String techtitlename) {
        this.techtitlename = techtitlename == null ? null : techtitlename.trim();
    }

    public String getLevelkind() {
        return levelkind;
    }

    public void setLevelkind(String levelkind) {
        this.levelkind = levelkind == null ? null : levelkind.trim();
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