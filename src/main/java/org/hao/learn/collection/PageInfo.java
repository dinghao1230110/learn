package org.hao.learn.collection;

import org.hao.learn.aggregate.DomainAggregate;

import java.util.List;

public class PageInfo<T extends DomainAggregate> {
    private int     pageIndex;
    private int     pageSize;
    private long    total;
    private List<T> data;

    public PageInfo() {
    }

    public PageInfo(int pageIndex, int pageSize, long total, List<T> data) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
