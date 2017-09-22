package org.hao.learn.test.lab;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jodd.io.FileUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FreemarkerTest {
    @Autowired
    private Configuration configuration;

    @Test
    public void main() throws IOException, TemplateException {
        String filePath = "d:/template/Domain.java";
        File   file     = new File(filePath);
        file.createNewFile();

        Map<String, Object> map = new HashMap<>();
        map.put("groupId", "org.hao.learn");
        map.put("packageName", "person.domain");
        map.put("className", "Domain");
        map.put("fieldType", "String");
        map.put("fieldName", "firstName");

        FileWriter fileWriter = new FileWriter(filePath);

        //获取模板
        Template template = configuration.getTemplate("domain.ftl");
        //执行模板引擎
        template.process(map, fileWriter);

        fileWriter.close();
    }
}
