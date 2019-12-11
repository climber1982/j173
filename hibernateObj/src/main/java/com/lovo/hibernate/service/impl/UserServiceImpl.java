package com.lovo.hibernate.service.impl;

import com.lovo.hibernate.dao.IUserDao;
import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.entity.RoleUserEntity;
import com.lovo.hibernate.entity.UserEntity;
import com.lovo.hibernate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService {
  @Autowired
    private IUserDao userDao;


    public void savaUser(UserEntity userEntity) {
        userDao.savaUser(userEntity);
    }

    @Override
    public UserEntity getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public List<String> getRoleListByUserId(String id, int tag) {
        List<String> listRoleName=new ArrayList<>();
        //获取用户对象
     UserEntity userEntity=   userDao.getUserById(id);
     //获得角色用户集合
    List<RoleUserEntity> roleUserEntityList=      userEntity.getRoleUserEntityList();
        for (RoleUserEntity ru:roleUserEntityList) {
            //获取去标志相同的数据
            if(tag==ru.getTag()) {
                RoleEntity role = ru.getRole();
                //把角色明装入集合中
                listRoleName.add(role.getRoleName());
            }
        }
        return listRoleName;
    }
}
