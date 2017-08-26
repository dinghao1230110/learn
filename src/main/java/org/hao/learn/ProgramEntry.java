package org.hao.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Jao on 2017/8/25.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class ProgramEntry {
    public static void main(String[] args) {
        SpringApplication.run(ProgramEntry.class, args);
    }
}
