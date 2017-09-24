package org.hao.learn.person.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FunctionDao {
    List<Long> queryFunction(long id);

    String queryFunctionName(long id);
}
