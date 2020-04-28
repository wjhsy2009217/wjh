package com.hzgc.project.system.user.domain;

import java.util.Date;

public class PzUserKind {
    private Integer userkindid;

    private String userkindname;

    private Date createtime;

    private Date modifytime;

    public Integer getUserkindid() {
        return userkindid;
    }

    public void setUserkindid(Integer userkindid) {
        this.userkindid = userkindid;
    }

    public String getUserkindname() {
        return userkindname;
    }

    public void setUserkindname(String userkindname) {
        this.userkindname = userkindname == null ? null : userkindname.trim();
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