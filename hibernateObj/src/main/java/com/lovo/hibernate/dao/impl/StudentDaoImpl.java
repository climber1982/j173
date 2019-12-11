package com.lovo.hibernate.dao.impl;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.dao.IStudentDao;
import com.lovo.hibernate.entity.StudentEntity;
import org.springframework.stereotype.Repository;

@Repository(value = "studentDao")
public class StudentDaoImpl extends BasicDAO implements IStudentDao {

    @Override
    public void savaStudent(StudentEntity studentEntity) {
         super.getCurrentSession().save(studentEntity);
    }

    @Override
    public StudentEntity getStudentById(long id) {
        return super.getCurrentSession().get(StudentEntity.class,id);
    }
}
