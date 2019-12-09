package com.lovo.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_user")//映射表面，默认就是类名
public class UserEntity {
    @Id //标注为ID
    @Column(name = "id",length = 32)//映射数据库的列
    private String userId;
    @Column(length = 48)
    private String userName;
    @Column(name = "age")
    private int userAge;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
