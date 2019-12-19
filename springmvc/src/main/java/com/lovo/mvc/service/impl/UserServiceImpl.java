package com.lovo.mvc.service.impl;

import com.lovo.mvc.dao.IUserDao;
import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    public void savaUser(UserEntity user) {
        userDao.save(user);
    }
}
