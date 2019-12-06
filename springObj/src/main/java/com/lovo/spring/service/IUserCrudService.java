package com.lovo.spring.service;

import com.lovo.spring.bean.UserBean;

import java.util.List;

public interface IUserCrudService {
    /**
     * 保存用户
     * @param user
     */
    public  void savaUser(UserBean user);
    /**
     * 保存用户
     * @param user
     */
    public  void savaUser2(UserBean user);
    /**
     * 查询所有用户
     * @return
     */
    public List<UserBean> findUserList();
}
