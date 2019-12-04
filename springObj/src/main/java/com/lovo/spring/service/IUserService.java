package com.lovo.spring.service;

import com.lovo.spring.bean.UserBean;

public interface IUserService {
    /**
     * 保存用户
     * @param userBean
     */
    public  void savaUser(UserBean userBean);


    /**
     * 用户名获取年龄
     * @param userName
     * @return
     */
    public int getAgeByName(String userName);
}
