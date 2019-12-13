package com.lovo.hibernate.service.impl;

import com.lovo.hibernate.dao.impl.PersonDaoImpl;
import com.lovo.hibernate.entity.UserEntity;
import com.lovo.hibernate.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "personService")
@Transactional
public class PersonServiceImpl implements IPersonService {
    @Autowired
    PersonDaoImpl personDao;

    public void savaUser(UserEntity userEntity) {
        personDao.savaObj(userEntity);
    }

    @Override
    public void delUserById(String id) {
        personDao.delObjById(id);
    }

    @Override
    public List<UserEntity> getListUserByAge(int age) {
        return personDao.getListParam("from UserEntity where userAge=?0",new Object[]{age});
    }
}
