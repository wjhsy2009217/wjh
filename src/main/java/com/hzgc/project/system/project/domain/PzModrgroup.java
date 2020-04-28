package com.hzgc.project.system.project.domain;

import java.util.Date;

public class PzModrgroup{
    private String ownright;

    private Date createtime;

    private Date modifytime;

    private Integer rightgroupid;

    private Integer moduleid;

    public Integer getRightgroupid() {
        return rightgroupid;
    }

    public void setRightgroupid(Integer rightgroupid) {
        this.rightgroupid = rightgroupid;
    }

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    public String getOwnright() {
        return ownright;
    }

    public void setOwnright(String ownright) {
        this.ownright = ownright == null ? null : ownright.trim();
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