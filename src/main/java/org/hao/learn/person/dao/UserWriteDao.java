package org.hao.learn.person.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hao.learn.sql.SqlField;
import org.hao.learn.person.domain.UserInfo;

import java.util.List;

/**
 * Created by Jao on 2017/8/25.
 */
@Mapper
public interface UserWriteDao {
    /**
     * 1个参数不用写@Param，但是必须在mapper.xml中指定parameterType类型
     *
     * @param userInfo
     * @return
     */
    int insertUser(UserInfo userInfo);

    /**
     * 2个（或2个以上）参数必须使用@Param注解，可以再mapper.xml中不用指定parameterType类型
     *
     * @param userInfo
     * @return
     */
    int updateUser(@Param("userInfo") UserInfo userInfo,
                   @Param("sqlFields") List<SqlField> sqlFields);

    int deleteUser(long id);
}
