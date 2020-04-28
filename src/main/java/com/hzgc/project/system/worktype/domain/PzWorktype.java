package com.hzgc.project.system.worktype.domain;

import java.util.Date;

public class PzWorktype {
    private Integer worktypeid;

    private String worktypename;

    private Date createtime;

    private Date modifytime;

    public Integer getWorktypeid() {
        return worktypeid;
    }

    public void setWorktypeid(Integer worktypeid) {
        this.worktypeid = worktypeid;
    }

    public String getWorktypename() {
        return worktypename;
    }

    public void setWorktypename(String worktypename) {
        this.worktypename = worktypename == null ? null : worktypename.trim();
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