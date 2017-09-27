package org.hao.learn.person.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hao.learn.person.domain.LogInfo;

@Mapper
public interface LogDao {
    int insertLog(@Param("logInfo") LogInfo logInfo);
}
