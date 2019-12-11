package com.lovo.hibernate.dao;

import com.lovo.hibernate.entity.RoleEntity;

import java.util.List;

public interface IRoleDao {
    /**
     * 根据用户名查询出所有的角色
     * @param userName
     * @return
     */
    public List<RoleEntity> getRoleListByUserName(String userName);
}
