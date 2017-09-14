package org.hao.learn.person.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jodd.datetime.JDateTime;
import org.hao.learn.aggregate.DomainAggregate;
import org.hao.learn.serializer.JDateTimeDeserializer;
import org.hao.learn.serializer.JDateTimeSerializer;

import java.lang.reflect.Field;

/**
 * Created by Jao on 2017/8/25.
 */
public class UserInfo implements DomainAggregate {
    protected long id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phone;
    protected String loginName;
    protected String loginPassword;
    @JsonDeserialize(using = JDateTimeDeserializer.class)
    @JsonSerialize(using = JDateTimeSerializer.class)
    protected JDateTime lastLoginDate;
    protected String lastLoginIp;
    protected byte status;

    //region property
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public JDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(JDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
    //endregion

    //反射代码
  /*  public Object get(String fieldName) throws Exception {
        Field field = this.getClass().getDeclaredField(fieldName);
        Object value = field.get(this);
        return value;
    }*/
}
