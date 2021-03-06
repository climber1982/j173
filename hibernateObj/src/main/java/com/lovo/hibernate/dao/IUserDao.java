package com.lovo.hibernate.dao;

import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.entity.UserEntity;

import java.util.List;

public interface IUserDao {
    /**
     * 保存用户
     * @param user
     */
    public  void savaUser(UserEntity user);
    /**
     * 保存用户
     * @param user
     */
    public  void savaUser2(UserEntity user);

    public UserEntity getUserById(String id);

    public  void  updateUser(String id);
    public  UserEntity getUser(String id);



}
