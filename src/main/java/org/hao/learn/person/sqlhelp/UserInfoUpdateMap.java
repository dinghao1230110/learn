package org.hao.learn.person.sqlhelp;

import org.hao.learn.person.domain.UserInfoMate;
import org.hao.learn.sql.SqlUpdate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserInfoUpdateMap extends HashMap<String, SqlUpdate> {
    public UserInfoUpdateMap() {
        this.put(UserInfoMate.SQL_ID_FIELD, new SqlUpdate("fieldName", "sqlName"));
    }

    public SqlUpdate getId() {
        return this.get(UserInfoMate.SQL_ID_FIELD);
    }

    public List<SqlUpdate> toList() {
        List<SqlUpdate> lst = new ArrayList<>();
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
