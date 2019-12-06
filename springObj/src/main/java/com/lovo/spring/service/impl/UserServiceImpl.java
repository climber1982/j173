package com.lovo.spring.service.impl;

import com.lovo.spring.bean.UserBean;
import com.lovo.spring.dao.IUserDao;
import com.lovo.spring.service.IUserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class UserServiceImpl implements IUserService {
    //持有DAO的接口引用
    private IUserDao userDao;
    //@Transactional(rollbackFor = {Exception.class},propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public void savaUser(UserBean userBean) {
        //调用DAO的方法
          userDao.savaUser(userBean);
          int i=1/0;
    }


    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int getAgeByName(String userName) {
        return userDao.getAgeByName(userName);
    }
}
