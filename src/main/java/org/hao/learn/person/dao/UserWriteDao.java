package org.hao.learn.person.dao;

import org.apache.ibatis.annotations.Mapper;
import org.hao.learn.person.domain.UserInfo;

/**
 * Created by Jao on 2017/8/25.
 */
@Mapper
public interface UserWriteDao {
    int insertUser(UserInfo userInfo);
}
