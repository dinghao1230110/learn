package org.hao.learn.person.sqlhelp;

import org.hao.learn.person.domain.UserInfoMate;
import org.hao.learn.sql.SqlQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserInfoQueryMap extends HashMap<String, SqlQuery> {
    public UserInfoQueryMap() {
        this.put(UserInfoMate.SQL_ID_FIELD, new SqlQuery("sqlName"));
    }

    public SqlQuery getId() {
        return this.get(UserInfoMate.SQL_ID_FIELD);
    }

    public List<SqlQuery> toList() {
        List<SqlQuery> lst = new ArrayList<>();
        for (String key : this.keySet()) {
            lst.add(this.get(key));
        }
        return lst;
    }

    public void resetAll() {
        for (String key : this.keySet()) {
            this.get(key).reset();
        }
    }
}
