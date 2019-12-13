package com.lovo.hibernate.dao.impl;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "personDao")
public class PersonDaoImpl extends BasicDAO<UserEntity,String> {

}
