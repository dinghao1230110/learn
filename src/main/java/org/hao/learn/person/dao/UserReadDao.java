package org.hao.learn.person.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hao.learn.database.Limit;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.sql.SqlQuery;

import java.util.List;

@Mapper
public interface UserReadDao {
    UserInfo queryById(long id);

    List<UserInfo> queryAll(Limit limit);

    List<UserInfo> queryBy(@Param("sqlQueries") List<SqlQuery> sqlQueries,
                           @Param("limit") Limit limit);
}
