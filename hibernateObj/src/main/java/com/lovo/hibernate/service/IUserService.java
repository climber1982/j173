package com.lovo.hibernate.service;

import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.entity.UserEntity;

import java.util.List;

public interface IUserService {

    public  void savaUser(UserEntity userEntity);
    public  UserEntity getUser(String id);

    /**
     * 根据用户ID查询出该用户拥有的所有角色
     * @param id 用户ID
     * @param tag 0-正常角色，1-冻结角色
     * @return  角色集合
     */
    public List<String> getRoleListByUserId(String id, int tag);
}
