package com.lovo.hibernate.service;

import com.lovo.hibernate.entity.StudentEntity;

public interface IStudentService {

    public  void savaStudent(StudentEntity studentEntity);

    public StudentEntity getStudentById(long id);
}
