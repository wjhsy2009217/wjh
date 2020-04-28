package com.hzgc.project.system.project.domain;

import java.util.Date;

public class PzModule {
    private Integer moduleid;

    private String modulename;

    private Integer modulegroupid;

    private Date createtime;

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public Integer getModulegroupid() {
        return modulegroupid;
    }

    public void setModulegroupid(Integer modulegroupid) {
        this.modulegroupid = modulegroupid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}