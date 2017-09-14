package org.hao.learn.database;

/**
 * Created by Jao on 2017/8/25.
 */
public class Limit {
    private int  pageIndex;
    private int  pageSize;
    private long size;
    private long offset;

    public Limit() {
    }

    public Limit(long size, long offset) {
        this.size = size;
        this.offset = offset;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public static Limit generateLimitByPage(int pageIndex, int pageSize) {
        if (pageIndex <= 0) {
            pageIndex = 1;
        }
        if (pageSize <= 0) {
            pageSize = 1;
        }

        long size   = pageSize;
        long offset = (pageIndex - 1) * pageSize;

        Limit limit = new Limit(size, offset);
        limit.pageIndex = pageIndex;
        limit.pageSize = pageSize;

        return limit;
    }
}
