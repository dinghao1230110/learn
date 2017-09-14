package org.hao.learn.test;

import org.hao.learn.ProgramEntry;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ProgramEntry.class)
@RunWith(SpringRunner.class)
public abstract class ServiceBaseTest {
}
