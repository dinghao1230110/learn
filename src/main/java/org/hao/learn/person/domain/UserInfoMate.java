package org.hao.learn.person.domain;

import org.hao.learn.sql.SqlField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoMate {

    public static final String ID_FIELD              = "id";
    public static final String FIRST_NAME_FIELD      = "firstName";
    public static final String LAST_NAME_FIELD       = "lastName";
    public static final String EMAIL_FIELD           = "email";
    public static final String PHONE_FIELD           = "phone";
    public static final String LOGIN_NAME_FIELD      = "loginName";
    public static final String LOGIN_PASSWORD_FIELD  = "loginPassword";
    public static final String LAST_LOGIN_DATE_FIELD = "lastLoginDate";
    public static final String LAST_LOGIN_IP_FIELD   = "lastLoginIp";
    public static final String STATUS_FIELD          = "status";

    public static final String SQL_ID_FIELD              = "ID";
    public static final String SQL_FIRST_NAME_FIELD      = "FIRST_NAME";
    public static final String SQL_LAST_NAME_FIELD       = "LAST_NAME";
    public static final String SQL_EMAIL_FIELD           = "EMAIL";
    public static final String SQL_PHONE_FIELD           = "PHONE";
    public static final String SQL_LOGIN_NAME_FIELD      = "LOGIN_NAME";
    public static final String SQL_LOGIN_PASSWORD_FIELD  = "LOGIN_PASSWORD";
    public static final String SQL_LAST_LOGIN_DATE_FIELD = "LAST_LOGIN_DATE";
    public static final String SQL_LAST_LOGIN_IP_FIELD   = "LAST_LOGIN_IP";
    public static final String SQL_STATUS_FIELD          = "STATUS";

    //这里你自己替换成变量, 下面的类似
    public SqlField ID_INCLUDE_FIELD              = new SqlField(ID_FIELD, SQL_ID_FIELD, false);
    public SqlField FIRST_NAME_INCLUDE_FIELD      = new SqlField(FIRST_NAME_FIELD, SQL_FIRST_NAME_FIELD, false);
    public SqlField LAST_NAME_INCLUDE_FIELD       = new SqlField(LAST_NAME_FIELD, SQL_LAST_NAME_FIELD, false);
    public SqlField EMAIL_INCLUDE_FIELD           = new SqlField(EMAIL_FIELD, SQL_EMAIL_FIELD, false);
    public SqlField PHONE_INCLUDE_FIELD           = new SqlField(PHONE_FIELD, SQL_PHONE_FIELD, false);
    public SqlField LOGIN_NAME_INCLUDE_FIELD      = new SqlField(LOGIN_NAME_FIELD, SQL_LOGIN_NAME_FIELD, false);
    public SqlField LOGIN_PASSWORD_INCLUDE_FIELD  = new SqlField(LOGIN_PASSWORD_FIELD, SQL_LOGIN_PASSWORD_FIELD, false);
    public SqlField LAST_LOGIN_DATE_INCLUDE_FIELD = new SqlField(LAST_LOGIN_DATE_FIELD, SQL_LAST_LOGIN_DATE_FIELD, false);
    public SqlField LAST_LOGIN_IP_INCLUDE_FIELD   = new SqlField(LAST_LOGIN_IP_FIELD, SQL_LAST_LOGIN_IP_FIELD, false);
    public SqlField STATUS_INCLUDE_FIELD          = new SqlField(STATUS_FIELD, SQL_STATUS_FIELD, false);

    public List<SqlField> generateNotIncludeList() {
        Map<String, SqlField> map = generateNotIncludeMap();
        List<SqlField> sqlFields = new ArrayList<SqlField>();
        for (String key : map.keySet()) {
            sqlFields.add(map.get(key));
        }
        return sqlFields;
    }

    public Map<String, SqlField> generateNotIncludeMap() {
        Map<String, SqlField> map = new HashMap<String, SqlField>();
        map.put(ID_INCLUDE_FIELD.toString(), ID_INCLUDE_FIELD);
        map.put(FIRST_NAME_INCLUDE_FIELD.toString(), FIRST_NAME_INCLUDE_FIELD);
        map.put(LAST_NAME_INCLUDE_FIELD.toString(), LAST_NAME_INCLUDE_FIELD);
        map.put(EMAIL_INCLUDE_FIELD.toString(), EMAIL_INCLUDE_FIELD);
        map.put(PHONE_INCLUDE_FIELD.toString(), PHONE_INCLUDE_FIELD);
        map.put(LOGIN_NAME_INCLUDE_FIELD.toString(), LOGIN_NAME_INCLUDE_FIELD);
        map.put(LOGIN_PASSWORD_INCLUDE_FIELD.toString(), LOGIN_PASSWORD_INCLUDE_FIELD);
        map.put(LAST_LOGIN_DATE_INCLUDE_FIELD.toString(), LAST_LOGIN_DATE_INCLUDE_FIELD);
        map.put(LAST_LOGIN_IP_INCLUDE_FIELD.toString(), LAST_LOGIN_IP_INCLUDE_FIELD);
        map.put(STATUS_INCLUDE_FIELD.toString(), STATUS_INCLUDE_FIELD);
        return map;
    }
}

