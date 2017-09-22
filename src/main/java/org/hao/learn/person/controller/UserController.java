package org.hao.learn.person.controller;

import org.hao.learn.api.ReadDataBaseService;
import org.hao.learn.api.WriteDataBaseService;
import org.hao.learn.collection.PageInfo;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.domain.UserInfoMate;
import org.hao.learn.vtor.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Jao on 2017/8/25.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    //get 查询数据
    //put 更新数据
    //post 新增数据
    //delete 删除数据

    @Autowired
    WriteDataBaseService<UserInfo> writeDataBaseService;
    @Autowired
    ReadDataBaseService<UserInfo>  readDataBaseService;
    @Autowired
    HttpSession                    httpSession;

    @PostMapping("/login")
    public void login(@RequestBody UserInfo userInfo) {
        httpSession.setAttribute("userInfo", userInfo);
    }

    @PostMapping
    public void addUserInfo(@RequestBody
                            @Valid(value = {UserInfoMate.PHONE_FIELD}, isInclude = false)
                                    UserInfo userInfo) {
        userInfo.setId(1);
        //writeDataBaseService.add(userInfo);
    }

    @GetMapping("/byLoginName/{loginName}/{pageIndex}")
    public PageInfo<UserInfo> getByLoginName(@PathVariable("loginName") String loginName, @PathVariable("pageIndex") int pageIndex) {
        return readDataBaseService.queryByLoginName(loginName, pageIndex, 10);
    }

    @GetMapping
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("hao");
        return userInfo;
    }
}
