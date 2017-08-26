package org.hao.learn.database;

/**
 * Created by Jao on 2017/8/25.
 */
public class Limit {
    private long start;
    private long offset;

    public Limit() {
    }

    public Limit(long start, long offset) {
        this.start = start;
        this.offset = offset;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }
}
