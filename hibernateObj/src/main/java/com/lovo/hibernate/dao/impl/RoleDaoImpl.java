package com.lovo.hibernate.dao.impl;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.dao.IRoleDao;
import com.lovo.hibernate.entity.RoleEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoleDaoImpl extends BasicDAO implements IRoleDao {


    public List<RoleEntity> getRoleListByUserName(String userName) {


        return null;
    }
}
