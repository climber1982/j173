package com.lovo.hibernate.service.impl;

import com.lovo.hibernate.dao.IStudentDao;
import com.lovo.hibernate.entity.StudentEntity;
import com.lovo.hibernate.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "studentService")
public class StudentServiceImpl implements IStudentService {
   @Autowired
    private IStudentDao studentDao;

    public void savaStudent(StudentEntity studentEntity) {
        studentDao.savaStudent(studentEntity);
    }

    @Override
    public StudentEntity getStudentById(long id) {
//     StudentEntity studentEntity=   studentDao.getStudentById(id);
//        System.out.println(studentEntity.getTeacher().getTeacherName());
        return studentDao.getStudentById(id);
    }
}
