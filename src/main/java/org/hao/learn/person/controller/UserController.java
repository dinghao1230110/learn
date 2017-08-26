package org.hao.learn.person.controller;

import org.hao.learn.api.WriteDataBaseService;
import org.hao.learn.person.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by Jao on 2017/8/25.
 */
@RestController
public class UserController {
    @Autowired
    WriteDataBaseService<UserInfo> userService;

    @PostConstruct
    public void add() {
        System.out.println();
    }
}
