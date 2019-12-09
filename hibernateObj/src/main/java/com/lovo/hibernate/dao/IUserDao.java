package com.lovo.hibernate.dao;

import com.lovo.hibernate.entity.UserEntity;

import java.util.List;

public interface IUserDao {
    /**
     * 保存用户
     * @param user
     */
    public  void savaUser(UserEntity user);

    public UserEntity getUserById(String id);

    //public List<UserEntity> getListUserList();
}
