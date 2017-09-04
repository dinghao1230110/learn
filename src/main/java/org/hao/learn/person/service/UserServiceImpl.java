package org.hao.learn.person.service;

import jodd.datetime.JDateTime;
import org.hao.learn.annotate.Function;
import org.hao.learn.bd.IncludeField;
import org.hao.learn.database.Limit;
import org.hao.learn.api.ReadDataBaseService;
import org.hao.learn.api.WriteDataBaseService;
import org.hao.learn.exception.MyException;
import org.hao.learn.person.dao.UserWriteDao;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.domain.UserInfoMate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    @Function(code = 1, name = "addUser", cnName = "新增用户")
    public void add(UserInfo domain) {
        int result = userWriteDao.insertUser(domain);
        if (result != 1) {
            throw new RuntimeException("新增用户失败");
        }
    }

    @Transactional
    public void batchAdd(List<UserInfo> domains) {
        int insertTotal = 0;
        for (UserInfo userInfo : domains) {
            int result = userWriteDao.insertUser(userInfo);
            insertTotal += result;
        }
        if (domains.size() != insertTotal) {
            throw new MyException("批量增加用户失败。预期增加数量：" + domains.size() + "，实际增加数量" + insertTotal);
        }
    }

    public void update(UserInfo domain) {
        UserInfoMate userInfoMate = new UserInfoMate();
        Map<String, IncludeField> includeStatusMap = userInfoMate.generateNotIncludeMap();
        includeStatusMap.get(userInfoMate.EMAIL_INCLUDE_FIELD.toString())
                .setInclude(true)
                .setValue(domain.getEmail());
        includeStatusMap.get(userInfoMate.FIRST_NAME_INCLUDE_FIELD.toString())
                .setInclude(true)
                .setValue(domain.getFirstName());
        includeStatusMap.get(userInfoMate.LAST_NAME_INCLUDE_FIELD.toString())
                .setInclude(true)
                .setValue(domain.getLastLoginDate());
        includeStatusMap.get(userInfoMate.LAST_LOGIN_DATE_INCLUDE_FIELD.toString())
                .setInclude(true)
                .setValue(domain.getLastLoginDate());

        UserInfo userInfo = new UserInfo();
        userInfo.setId(domain.getId());

        int result = userWriteDao.updateUser(domain, userInfoMate.generateNotIncludeList());
        if (result != 1) {
            throw new RuntimeException("修改用户失败");
        }
    }

    public void delete(UserInfo domain) {

    }

    @Transactional
    public void batchDelete(List<UserInfo> domains) {
        int insertTotal = 0;
        for (UserInfo userInfo : domains) {
            int result = userWriteDao.deleteUser(userInfo.getId());
            insertTotal += result;
        }
        if (domains.size() != insertTotal) {
            throw new MyException("批量删除用户失败。预期删除数量：" + domains.size() + "，实际删除数量" + insertTotal);
        }
    }
    //endregion
}
