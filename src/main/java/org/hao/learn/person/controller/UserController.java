package org.hao.learn.person.controller;

import org.hao.learn.annotate.Function;
import org.hao.learn.api.ReadDataBaseService;
import org.hao.learn.api.WriteDataBaseService;
import org.hao.learn.collection.PageInfo;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.domain.UserInfoMate;
import org.hao.learn.vtor.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    public UserInfo login(@RequestBody UserInfo userInfo) {

        httpSession.setAttribute("userInfo", userInfo);
        readDataBaseService.queryByLoginName("Hao", 1, 10);
        return userInfo;
    }

    @PostMapping("/add")
    @Function(6317038017294901248L)
    public void addUserInfo(@RequestBody
                            @Valid(value = {UserInfoMate.PHONE_FIELD, UserInfoMate.EMAIL_FIELD}, isInclude = true)
                                    UserInfo userInfo) {
        userInfo.setId(1);
        //writeDataBaseService.add(userInfo);
    }

    @GetMapping("/byLoginName/{loginName}/{pageIndex}")
    @Function(6317038017294897152L)
    public PageInfo<UserInfo> getByLoginName(@PathVariable("loginName") String loginName, @PathVariable("pageIndex") int pageIndex) {
        return readDataBaseService.queryByLoginName(loginName, pageIndex, 10);
    }


    //@Function(6317038017294905344L) 批量新增用户
    //@Function(6317038017299103744L) 更新用户
    //@Function(6317038017299107840L) 删除单个用户
    //@Function(6317038017299111936L) 批量删除用户
}
