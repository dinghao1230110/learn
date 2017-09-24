package org.hao.learn.person.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hao.learn.annotate.Function;
import org.hao.learn.person.domain.FunctionInfo;
import org.hao.learn.person.domain.RoleFunction;
import org.hao.learn.person.domain.RoleInfo;

import java.util.List;

@Mapper
public interface FunctionDao {
    List<Long> queryFunction(long id);

    String queryFunctionName(long id);

    List<FunctionInfo> queryAllFunction();

    List<RoleFunction> queryFunctionByRole(@Param("roles") List<RoleInfo> roles);
}
