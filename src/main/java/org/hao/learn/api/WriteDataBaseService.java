package org.hao.learn.api;

import org.hao.learn.aggregate.DomainAggregate;

import java.util.List;

/**
 * Created by Jao on 2017/8/25.
 */
public interface WriteDataBaseService<T extends DomainAggregate> {
    void add(T domain);

    void batchAdd(List<T> domains);

    void update(T domain);

    void delete(T domain);

    void batchDelete(List<T> domains);
}
