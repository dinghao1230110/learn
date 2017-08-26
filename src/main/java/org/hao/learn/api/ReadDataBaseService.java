package org.hao.learn.api;

import org.hao.learn.aggregate.DomainAggregate;
import org.hao.learn.database.Limit;

import java.util.List;

/**
 * Created by Jao on 2017/8/25.
 */
public interface ReadDataBaseService<T extends DomainAggregate> {
    T queryById(long id);

    List<T> queryAll(Limit limit);

    List<T> queryBy(T domain, Limit limit);
}
