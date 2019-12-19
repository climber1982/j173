package com.lovo.mvc.service;

import com.lovo.mvc.entity.UserEntity;

public interface IUserService {
    /**
     * 保存用户
     * @param user
     */
    public  void savaUser(UserEntity user);
}
