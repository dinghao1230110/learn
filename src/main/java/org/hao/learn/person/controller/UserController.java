package org.hao.learn.person.controller;

import org.hao.learn.api.WriteDataBaseService;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.domain.UserInfoMate;
import org.hao.learn.vtor.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * Created by Jao on 2017/8/25.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    WriteDataBaseService<UserInfo> userService;

    @PostMapping
    public void addUserInfo(@RequestBody
                            @Valid({UserInfoMate.PHONE_FIELD, UserInfoMate.EMAIL_FIELD, UserInfoMate.LAST_NAME_FIELD})
                                    UserInfo userInfo) {
        userInfo.setId(1);
        //userService.add(userInfo);
    }

    @GetMapping
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("hao");
        return userInfo;
    }
}
