package com.hzgc.project.system.system.domain;

import java.util.Date;

public class PzSystemSet {
    private Integer systemid;

    private String variable;

    private String variablechar;

    private Date createtime;

    private Date modifytime;

    public Integer getSystemid() {
        return systemid;
    }

    public void setSystemid(Integer systemid) {
        this.systemid = systemid;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable == null ? null : variable.trim();
    }

    public String getVariablechar() {
        return variablechar;
    }

    public void setVariablechar(String variablechar) {
        this.variablechar = variablechar == null ? null : variablechar.trim();
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