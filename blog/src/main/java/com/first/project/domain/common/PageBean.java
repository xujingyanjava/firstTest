package com.first.project.domain.common;

import java.util.List;

/**
 * 分页返回类
 * @param <T>
 *     当前页数
 *     总页数
 *     每页数量
 *     总数量
 *     返回list
 */
public class PageBean<T> {

    /**
     * 返回
     */
    private List<T> record;

    /**
     * 当前页数
     */
    private int currentPage;

    /**
     * 每页显示数量
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 总数量
     */
    private int totalCount;

    public List<T> getRecord() {
        return record;
    }

    public void setRecord(List<T> record) {
        this.record = record;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
