package com.lovo.sh.dao;

import com.lovo.sh.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao  extends CrudRepository<UserEntity,String> {


}
