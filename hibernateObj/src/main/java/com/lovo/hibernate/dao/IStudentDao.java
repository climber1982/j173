package com.lovo.hibernate.dao;

import com.lovo.hibernate.entity.StudentEntity;

public interface IStudentDao {

    public  void savaStudent(StudentEntity studentEntity);

    public StudentEntity getStudentById(long id);
}
