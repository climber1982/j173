package com.lovo.mvc.dao;

import com.lovo.mvc.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<UserEntity,String> {


}
