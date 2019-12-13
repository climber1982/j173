package com.lovo.sh.dao;

import com.lovo.sh.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface IUserDao  extends CrudRepository<UserEntity,String> {
    @Query("from UserEntity where userAge=:age")
    public List<UserEntity> getUserListByAge(@Param("age") int age);
    @Query("from UserEntity")
    public List<UserEntity> getUserListByAge();
    @Query("select new map(userName,userAge) from UserEntity")
    public List<Map> getUserListMap();

   @Query(value = "select * from sys_user where age=?1",nativeQuery = true)
    public List<UserEntity> getUserListByAgeSQL(int age);
   @Query("update  UserEntity set userAge=?1 where userName=?2")
   @Modifying  //执行修改、删除语句
   public void updateUser(int age,String userName);
}
