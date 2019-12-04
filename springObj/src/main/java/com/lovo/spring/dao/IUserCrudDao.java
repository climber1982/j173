package com.lovo.spring.dao;

import com.lovo.spring.bean.UserBean;

import java.util.List;

public interface IUserCrudDao {
    /**
     * 保存用户
     * @param user
     */
    public  void savaUser(UserBean user);

    /**
     * 查询所有用户
     * @return
     */
    public List<UserBean> findUserList();
}
