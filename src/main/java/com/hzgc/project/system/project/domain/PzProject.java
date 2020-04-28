package com.hzgc.project.system.project.domain;

import java.util.Date;
import java.util.List;

public class PzProject {
    private Integer projectid;

    private String projectname;

    private Date createtime;

    private List<PzModulegroup> pzModulegroups;


    public List<PzModulegroup> getPzModulegroups() {
        return pzModulegroups;
    }

    public void setPzModulegroups(List<PzModulegroup> pzModulegroups) {
        this.pzModulegroups = pzModulegroups;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}