package com.hzgc.project.system.rightgroup.domain;

import java.util.Date;

public class PzRightgroup {
    private Integer rightgroupid;

    private String rightgroupname;

    private Integer level;

    private Date createtime;

    private Date modifytime;

    public Integer getRightgroupid() {
        return rightgroupid;
    }

    public void setRightgroupid(Integer rightgroupid) {
        this.rightgroupid = rightgroupid;
    }

    public String getRightgroupname() {
        return rightgroupname;
    }

    public void setRightgroupname(String rightgroupname) {
        this.rightgroupname = rightgroupname == null ? null : rightgroupname.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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