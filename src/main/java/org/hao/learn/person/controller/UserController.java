package org.hao.learn.person.controller;

import org.hao.learn.api.ReadDataBaseService;
import org.hao.learn.api.WriteDataBaseService;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.domain.UserInfoMate;
import org.hao.learn.vtor.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void addUserInfo(@RequestBody
                            @Valid(value = {UserInfoMate.PHONE_FIELD}, isInclude = false)
                                    UserInfo userInfo) {
        userInfo.setId(1);
        //writeDataBaseService.add(userInfo);
    }

    @GetMapping("/byLoginName")
    public void getByLoginName() {
        readDataBaseService.queryByLoginName(null, 1, 1);
    }

    @GetMapping
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("hao");
        return userInfo;
    }
}
