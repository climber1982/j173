package com.lovo.sh.service.impl;

import com.lovo.sh.dao.IUserDao;
import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
