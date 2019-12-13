package com.lovo.sh.dao;

import com.lovo.sh.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserDao  extends CrudRepository<UserEntity,String> {
    @Query("from UserEntity where userAge=:age")
    public List<UserEntity> getUserListByAge(@Param("age") int age);
}
