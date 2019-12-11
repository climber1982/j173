package com.lovo.hibernate.service.impl;

import com.lovo.hibernate.dao.ITeacherDao;
import com.lovo.hibernate.entity.StudentEntity;
import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service(value = "teacherService")
@Transactional
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherDao teacherDao;
    @Override
    public void savaTeacher(TeacherEntity teacher) {
        teacherDao.savaTeacher(teacher);
    }

    @Override
    public TeacherEntity getTeacherById(long id) {
       TeacherEntity teacherEntity= teacherDao.getTeacherById(id);
        //获得学生集合
        Set<StudentEntity> set= teacherEntity.getStuSet();
        for (StudentEntity stu:set) {
            System.out.println(stu.getStudentName());
        }
        return teacherEntity;
    }
}
