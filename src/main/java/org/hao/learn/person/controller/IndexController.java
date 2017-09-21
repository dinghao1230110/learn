package org.hao.learn.person.controller;

import org.hao.learn.person.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String getUserInfo(ModelMap modelMap) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(10000);
        userInfo.setFirstName("");
        userInfo.setLastName("Tinker");

        List<UserInfo> users = new ArrayList<>();

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(10000);
        userInfo1.setFirstName("丁");
        userInfo1.setLastName("浩");
        users.add(userInfo1);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(10001);
        userInfo2.setFirstName("田");
        userInfo2.setLastName("西泽");
        users.add(userInfo2);

        modelMap.addAttribute("userInfo", userInfo);
        modelMap.addAttribute("users", users);

        return "index";
    }
}
