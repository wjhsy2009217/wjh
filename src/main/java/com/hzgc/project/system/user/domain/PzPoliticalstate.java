package com.hzgc.project.system.user.domain;

import java.util.Date;

public class PzPoliticalstate {
    private Integer politicalstateid;

    private String politicalstatename;

    private Date createtime;

    private Date modifytime;

    public Integer getPoliticalstateid() {
        return politicalstateid;
    }

    public void setPoliticalstateid(Integer politicalstateid) {
        this.politicalstateid = politicalstateid;
    }

    public String getPoliticalstatename() {
        return politicalstatename;
    }

    public void setPoliticalstatename(String politicalstatename) {
        this.politicalstatename = politicalstatename == null ? null : politicalstatename.trim();
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