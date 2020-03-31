package com.hzgc.project.common;

public class PageParam {
    private int start;
    private int limit;
    private boolean desc = false;

    public int getStart() {
        return start;
    }

    public PageParam setStart(int start) {
        this.start = start;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public PageParam setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public boolean isDesc() {
        return desc;
    }

    public PageParam setDesc(boolean desc) {
        this.desc = desc;
        return this;
    }

    public static PageParam builder() {
        return new PageParam();
    }
}
