package org.hao.learn.person.domain;

import org.hao.learn.bd.IncludeField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoMate {

    public IncludeField ID_INCLUDE_FIELD = new IncludeField("id", "ID", false);
    public IncludeField FIRST_NAME_INCLUDE_FIELD = new IncludeField("firstName", "FIRST_NAME", false);
    public IncludeField LAST_NAME_INCLUDE_FIELD = new IncludeField("lastName", "LAST_NAME", false);
    public IncludeField EMAIL_INCLUDE_FIELD = new IncludeField("email", "EMAIL", false);
    public IncludeField PHONE_INCLUDE_FIELD = new IncludeField("phone", "PHONE", false);
    public IncludeField LOGIN_NAME_INCLUDE_FIELD = new IncludeField("loginName", "LOGIN_NAME", false);
    public IncludeField LOGIN_PASSWORD_INCLUDE_FIELD = new IncludeField("loginPassword", "LOGIN_PASSWORD", false);
    public IncludeField LAST_LOGIN_DATE_INCLUDE_FIELD = new IncludeField("lastLoginDate", "LAST_LOGIN_DATE", false);
    public IncludeField LAST_LOGIN_IP_INCLUDE_FIELD = new IncludeField("lastLoginIp", "LAST_LOGIN_IP", false);
    public IncludeField STATUS_INCLUDE_FIELD = new IncludeField("status", "STATUS", false);

    public List<IncludeField> generateNotIncludeList() {
        Map<String, IncludeField> map = generateNotIncludeMap();
        List<IncludeField> includeFields = new ArrayList<IncludeField>();
        for (String key : map.keySet()) {
            includeFields.add(map.get(key));
        }
        return includeFields;
    }

    public Map<String, IncludeField> generateNotIncludeMap() {
        Map<String, IncludeField> map = new HashMap<String, IncludeField>();
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
