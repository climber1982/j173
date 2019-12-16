package com.lovo.sh.service;

import com.lovo.sh.entity.UserDto;
import com.lovo.sh.entity.UserEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

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

    public List<Map> getUserListMap();
    public List<UserEntity> getUserListByAgeSQL(int age);
    public void updateUser(int age,String userName);

    public List<Map> getUserListMapSql();

    public UserEntity findByUserAgeAndUserName(int age,String userName);

    /**
     * 分页查询
     * @param age
     * @return
     */
    public List<UserEntity> findListByAgePage(int age);

}
