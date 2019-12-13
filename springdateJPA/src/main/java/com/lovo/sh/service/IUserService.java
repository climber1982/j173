package com.lovo.sh.service;

import com.lovo.sh.entity.UserEntity;

import java.util.List;

public interface IUserService {
    /**
     * 保存用户
     * @param user
     */
    public  void savaUser(UserEntity user);

    /**
     * 根据年龄查询用户集合
     * @param age
     * @return
     */
    public List<UserEntity> getUserListByAge(int age);

    public  UserEntity getUserById(String id);

    public  UserEntity getUserByName(String name);

    public  List<UserEntity> findAll();

}
