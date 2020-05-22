package com.hzgc.project.system.custom.domain;

import java.util.Date;

public class PzRightcustomer{
    private Integer id;

    public Integer getId() {
        return id;
    }

    private Date createtime;

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer rightgroupid;

    private Long customerid;

    public Integer getRightgroupid() {
        return rightgroupid;
    }

    public void setRightgroupid(Integer rightgroupid) {
        this.rightgroupid = rightgroupid;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}