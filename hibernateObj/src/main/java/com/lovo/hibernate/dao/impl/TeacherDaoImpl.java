package com.lovo.hibernate.dao.impl;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.dao.ITeacherDao;
import com.lovo.hibernate.entity.TeacherEntity;
import org.springframework.stereotype.Repository;

@Repository(value = "teacherDao")
public class TeacherDaoImpl extends BasicDAO implements ITeacherDao {


    public void savaTeacher(TeacherEntity teacher) {
       super.getCurrentSession().save(teacher);
    }

    @Override
    public TeacherEntity getTeacherById(long id) {
        return super.getCurrentSession().get(TeacherEntity.class,id);
    }
}
