package com.tfms.model;

import javax.validation.constraints.NotNull;

/**
 * @author ZhaoJiaLin
 * @date 2020-11-22 18:17
 * @description：
 */
public class PageMessage {
    /**
     * 当前记录起始索引
     */
    private volatile Integer pageNum;

    /**

     * 每页显示记录数
     */
    private volatile Integer pageSize;


    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PageMessage() {
    }

    public PageMessage(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageMessage{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
