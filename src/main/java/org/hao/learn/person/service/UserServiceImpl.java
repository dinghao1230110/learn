package org.hao.learn.person.service;

import org.hao.learn.database.Limit;
import org.hao.learn.api.ReadDataBaseService;
import org.hao.learn.api.WriteDataBaseService;
import org.hao.learn.person.dao.UserWriteDao;
import org.hao.learn.person.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jao on 2017/8/25.
 */
@Service
@Primary
public class UserServiceImpl implements ReadDataBaseService<UserInfo>, WriteDataBaseService<UserInfo> {

    @Autowired
    UserWriteDao userWriteDao;

    //region read
    public UserInfo queryById(long id) {
        return null;
    }

    public List<UserInfo> queryAll(Limit limit) {
        return null;
    }

    public List<UserInfo> queryBy(UserInfo domain, Limit limit) {
        return null;
    }
    //endregion

    //region write
    public void add(UserInfo domain) {
        int result = userWriteDao.insertUser(domain);
        if (result != 1) {
            throw new RuntimeException("新增用户失败");
        }
    }

    public void batchAdd(List<UserInfo> domains) {

    }

    public void update(UserInfo domain) {

    }

    public void delete(UserInfo domain) {

    }

    public void batchDelete(List<UserInfo> domains) {

    }
    //endregion
}
