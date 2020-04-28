package com.hzgc.project.system.project.domain;

import java.util.Date;
import java.util.List;

public class PzModulegroup {
    private Integer modulegroupid;

    private String modulegroupname;

    private Integer projectid;

    private Date createtime;

    private List<PzModule> pzModules;

    public List<PzModule> getPzModules() {
        return pzModules;
    }

    public void setPzModules(List<PzModule> pzModules) {
        this.pzModules = pzModules;
    }

    public Integer getModulegroupid() {
        return modulegroupid;
    }

    public void setModulegroupid(Integer modulegroupid) {
        this.modulegroupid = modulegroupid;
    }

    public String getModulegroupname() {
        return modulegroupname;
    }

    public void setModulegroupname(String modulegroupname) {
        this.modulegroupname = modulegroupname == null ? null : modulegroupname.trim();
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