package com.lovo.hibernate.service;

import com.lovo.hibernate.entity.RoleEntity;

import java.util.List;

public interface IRoleService {
    /**
     * 根据用户名查询出所有的角色
     * @param userName
     * @return
     */
    public List<RoleEntity> getRoleListByUserName(String userName);
}
