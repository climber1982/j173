package com.lovo.sh.service.impl;

import com.lovo.sh.dao.IUserDao;
import com.lovo.sh.entity.UserDto;
import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService {
   @Autowired
    private IUserDao userDao;

    public void savaUser(UserEntity user) {
        userDao.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userDao.findAll();
    }

    @Override
    public List<UserEntity> getUserListByAge(int age) {
        if(0==age){
            return userDao.getUserListByAge();
        }
        return userDao.getUserListByAge(age);
    }

    @Override
    public UserEntity getUserById(String id) {
        return null;
    }

    @Override
    public UserEntity getUserByName(String name) {
        return null;
    }

    @Override
    public List<Map> getUserListMap() {
        return userDao.getUserListMap();
    }

    @Override
    public List<UserEntity> getUserListByAgeSQL(int age) {
        return userDao.getUserListByAgeSQL(age);
    }

    @Override
    public void updateUser(int age, String userName) {
        userDao.updateUser(age,userName);
    }

    @Override
    public List<Map> getUserListMapSql() {
        return userDao.getUserListMapSql();
    }

    @Override
    public UserEntity findByUserAgeAndUserName(int age, String userName) {
        return userDao.findByUserAgeAndUserName(age,userName);
    }

    @Override
    public List<UserEntity> findListByAgePage(int age) {
         //第一个参数 起始页数从0开始,第二个参数每页显示的行数
        Pageable pageable=PageRequest.of(1,3);
        return userDao.findListByAgePage(age,pageable);
    }
}
