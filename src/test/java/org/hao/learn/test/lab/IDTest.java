package org.hao.learn.test.lab;

import org.hao.learn.utils.SnowflakeUtil;
import org.junit.Test;

public class IDTest {
    @Test
    public void main() {
        for (int i = 0; i < 10; i++) {
            System.out.println(SnowflakeUtil.next());
        }
    }
}
