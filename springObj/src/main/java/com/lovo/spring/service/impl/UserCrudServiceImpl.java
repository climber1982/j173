package com.lovo.spring.service.impl;

import com.lovo.spring.bean.UserBean;
import com.lovo.spring.dao.IUserCrudDao;
import com.lovo.spring.service.IUserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "userCrudService")
public class UserCrudServiceImpl implements IUserCrudService {
    @Autowired
    private IUserCrudDao userCrudDao;
    @Override
    public void savaUser(UserBean user) {
        userCrudDao.savaUser(user);
    }

    @Override
    public List<UserBean> findUserList() {
        return userCrudDao.findUserList();
    }
}
