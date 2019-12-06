package com.lovo.spring.service.impl;

import com.lovo.spring.bean.UserBean;
import com.lovo.spring.dao.IUserCrudDao;
import com.lovo.spring.service.IUserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service(value = "userCrudService")
public class UserCrudServiceImpl implements IUserCrudService {
    @Autowired
    private IUserCrudDao userCrudDao;

    public void savaUser(UserBean user) {

     userCrudDao.savaUser(user);
     int i=1/0;
    }

    @Override
    public void savaUser2(UserBean user) {
        userCrudDao.savaUser(user);
        this.savaUser(user);
    }

    @Override
    public List<UserBean> findUserList() {
        return userCrudDao.findUserList();
    }
}
