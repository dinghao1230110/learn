package org.hao.learn.api;

import org.hao.learn.aggregate.DomainAggregate;
import org.hao.learn.collection.PageInfo;
import org.hao.learn.database.Limit;
import org.hao.learn.person.domain.UserInfo;

import java.util.List;

/**
 * Created by Jao on 2017/8/25.
 */
public interface ReadDataBaseService<T extends DomainAggregate> {
    T queryById(long id);

    PageInfo<T> queryAll(int pageIndex, int pageSize);

    PageInfo<T> queryByLoginName(String logName, int pageIndex, int pageSize);

    UserInfo queryByLogin(String loginName);
}
