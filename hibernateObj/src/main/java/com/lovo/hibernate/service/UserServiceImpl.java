package com.lovo.hibernate.service;

import com.lovo.hibernate.dao.IUserDao;
import com.lovo.hibernate.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService {
  @Autowired
    private IUserDao userDao;


    public void savaUser(UserEntity userEntity) {
        userDao.savaUser(userEntity);
    }
}
