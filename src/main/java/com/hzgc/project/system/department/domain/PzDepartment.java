package com.hzgc.project.system.department.domain;

import java.util.Date;

public class PzDepartment {
    private Integer departid;

    private String departname;

    private String departcode;

    private String outid;

    private String departfullid;

    private String departfullname;

    private Integer departfartherid;

    private Integer sort;

    private String usedflag;

    private String departtele;

    private String departaddress;

    private String departleader;

    private Date enddate;

    private Date createtime;

    private Date modifytime;

    public Integer getDepartid() {
        return departid;
    }

    public void setDepartid(Integer departid) {
        this.departid = departid;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname == null ? null : departname.trim();
    }

    public String getDepartcode() {
        return departcode;
    }

    public void setDepartcode(String departcode) {
        this.departcode = departcode == null ? null : departcode.trim();
    }

    public String getOutid() {
        return outid;
    }

    public void setOutid(String outid) {
        this.outid = outid == null ? null : outid.trim();
    }

    public String getDepartfullid() {
        return departfullid;
    }

    public void setDepartfullid(String departfullid) {
        this.departfullid = departfullid == null ? null : departfullid.trim();
    }

    public String getDepartfullname() {
        return departfullname;
    }

    public void setDepartfullname(String departfullname) {
        this.departfullname = departfullname == null ? null : departfullname.trim();
    }

    public Integer getDepartfartherid() {
        return departfartherid;
    }

    public void setDepartfartherid(Integer departfartherid) {
        this.departfartherid = departfartherid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUsedflag() {
        return usedflag;
    }

    public void setUsedflag(String usedflag) {
        this.usedflag = usedflag == null ? null : usedflag.trim();
    }

    public String getDeparttele() {
        return departtele;
    }

    public void setDeparttele(String departtele) {
        this.departtele = departtele == null ? null : departtele.trim();
    }

    public String getDepartaddress() {
        return departaddress;
    }

    public void setDepartaddress(String departaddress) {
        this.departaddress = departaddress == null ? null : departaddress.trim();
    }

    public String getDepartleader() {
        return departleader;
    }

    public void setDepartleader(String departleader) {
        this.departleader = departleader == null ? null : departleader.trim();
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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