package com.lovo.hibernate.service;

import com.lovo.hibernate.entity.UserEntity;

import java.util.List;

public interface IPersonService {
    /**
     * 保存对象
     * @param userEntity
     */
    public  void savaUser(UserEntity userEntity);

    public  void delUserById(String id);

    public List<UserEntity> getListUserByAge(int age);
}
