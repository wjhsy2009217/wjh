package com.hzgc.project.system.project.domain;

import java.util.Date;

public class PzProrgroup {
    private Integer rightgroupid;

    private Integer projectid;

    private Date createtime;

    public Integer getRightgroupid() {
        return rightgroupid;
    }

    public void setRightgroupid(Integer rightgroupid) {
        this.rightgroupid = rightgroupid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}