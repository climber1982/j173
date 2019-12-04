package com.lovo.spring.dao;

import com.lovo.spring.bean.UserBean;

public interface IUserDao {
    /**
     * 保存用户
     * @param user 用户对象
     */
    public  void savaUser(UserBean user);

    /**
     * 用户名获取年龄
     * @param userName
     * @return
     */
    public int getAgeByName(String userName);
}
