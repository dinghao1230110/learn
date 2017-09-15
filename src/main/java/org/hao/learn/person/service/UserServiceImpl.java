package org.hao.learn.person.service;

import jodd.util.StringUtil;
import org.hao.learn.annotate.Function;
import org.hao.learn.api.ReadDataBaseService;
import org.hao.learn.api.WriteDataBaseService;
import org.hao.learn.collection.PageInfo;
import org.hao.learn.database.Limit;
import org.hao.learn.exception.MyException;
import org.hao.learn.person.dao.UserReadDao;
import org.hao.learn.person.dao.UserWriteDao;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.domain.UserInfoMate;
import org.hao.learn.sql.SqlField;
import org.hao.learn.sql.SqlOperator;
import org.hao.learn.sql.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Autowired
    UserReadDao  userReadDao;

    //region read
    public UserInfo queryById(long id) {
        UserInfo userInfo = userReadDao.queryById(id);
        return userInfo;
    }

    public PageInfo<UserInfo> queryAll(int pageIndex, int pageSize) {
        Limit              limit    = Limit.generateLimitByPage(pageIndex, pageSize);
        long               total    = userReadDao.queryTotal();
        List<UserInfo>     result   = userReadDao.queryAll(limit);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(limit.getPageIndex(), limit.getPageSize(), total, result);
        return pageInfo;
    }

    /**
     * 根据登录名查询用户
     *
     * @param loginName
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<UserInfo> queryByLoginName(String loginName, int pageIndex, int pageSize) {
        if (!StringUtil.isNotEmpty(loginName)) {
            throw new MyException("登录名不能为空");
        }

        Limit limit = Limit.generateLimitByPage(pageIndex, pageSize);

        List<SqlQuery> sqlQueries = new ArrayList<>();
        sqlQueries.add(new SqlQuery(UserInfoMate.SQL_LOGIN_NAME_FIELD, SqlOperator.LIKE, loginName));

        long           total  = userReadDao.queryTotalBy(sqlQueries);
        List<UserInfo> result = userReadDao.queryBy(sqlQueries, limit);

        PageInfo<UserInfo> pageInfo = new PageInfo<>(limit.getPageIndex(), limit.getPageSize(), total, result);
        return pageInfo;
    }
    //endregion

    //region write

    /**
     * 新增用户
     *
     * @param domain
     */
    @Function(code = 1, name = "addUser", cnName = "新增用户")
    public void add(UserInfo domain) {
        int result = userWriteDao.insertUser(domain);
        if (result != 1) {
            throw new MyException("新增用户失败");
        }
    }

    /**
     * 批量删除用户
     *
     * @param domains
     */
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

    /**
     * 更新用户<br>
     * 更新email, 姓, 名, 最后登录时间
     *
     * @param domain
     */
    public void update(UserInfo domain) {
        UserInfoMate          userInfoMate     = new UserInfoMate();
        Map<String, SqlField> includeStatusMap = userInfoMate.generateNotIncludeMap();
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

    /**
     * 删除单个用户
     *
     * @param userInfo
     */
    public void delete(UserInfo userInfo) {
        int result = userWriteDao.deleteUser(userInfo.getId());
        if (result != 1) {
            throw new MyException("删除用户失败");
        }
    }

    /**
     * 批量删除用户
     *
     * @param domains
     */
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
