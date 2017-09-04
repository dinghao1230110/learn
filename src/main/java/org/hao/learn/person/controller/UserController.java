package org.hao.learn.person.controller;

import org.hao.learn.api.WriteDataBaseService;
import org.hao.learn.person.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * Created by Jao on 2017/8/25.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    WriteDataBaseService<UserInfo> userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addUserInfo(@RequestBody UserInfo userInfo) {
        userInfo.setId(1);
        userService.add(userInfo);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("hao");
        return userInfo;
    }
}
