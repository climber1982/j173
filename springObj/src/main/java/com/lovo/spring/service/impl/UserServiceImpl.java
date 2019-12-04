package com.lovo.spring.service.impl;

import com.lovo.spring.bean.UserBean;
import com.lovo.spring.dao.IUserDao;
import com.lovo.spring.service.IUserService;

public class UserServiceImpl implements IUserService {
    //持有DAO的接口引用
    private IUserDao userDao;

    public void savaUser(UserBean userBean) {
        //调用DAO的方法
          userDao.savaUser(userBean);
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
