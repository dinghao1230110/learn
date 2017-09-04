package org.hao.learn.utils;

import com.relops.snowflake.Snowflake;

/**
 * Created by XizeTian on 2017/6/30.
 */
public class SnowflakeUtil {
    private final static Object snowflakeLock = new Object();
    private static Snowflake[] SNOWFLAKES;
    private static short SnowflakeIndex = 0;
    private static short startNode      = 0;
    private static short endNode        = 5;
    private static short nodeTotal;

    static {
        if (SNOWFLAKES == null) {
            synchronized (snowflakeLock) {
                if (SNOWFLAKES == null) {
                    nodeTotal = (short) (endNode - startNode + 1);
                    SNOWFLAKES = new Snowflake[nodeTotal];
                    int j = 0;
                    for (int i = startNode; i <= endNode; i++, j++) {
                        SNOWFLAKES[j] = new Snowflake(i + 1);
                    }
                }
            }
        }
    }

    public static long next() {
        long id;
        synchronized (snowflakeLock) {
            try {
                id = SNOWFLAKES[SnowflakeIndex].next();
            } finally {
                SnowflakeIndex++;
                if (SnowflakeIndex >= nodeTotal) {
                    SnowflakeIndex = 0;
                }
            }
        }
        return id;
    }
}
