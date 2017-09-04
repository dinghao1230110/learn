package org.hao.learn.database;

/**
 * Created by Jao on 2017/8/25.
 */
public class Limit {
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
}
