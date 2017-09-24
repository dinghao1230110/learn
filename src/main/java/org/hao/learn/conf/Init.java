package org.hao.learn.conf;

import org.hao.learn.api.FunctionDataBaseService;
import org.hao.learn.person.domain.FunctionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Init {
    @Autowired
    FunctionDataBaseService<FunctionInfo> functionService;

    @PostConstruct
    public void initFunction(){
        functionService.refreshFunction();
    }
}
