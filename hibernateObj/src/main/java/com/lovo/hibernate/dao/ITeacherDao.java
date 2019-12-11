package com.lovo.hibernate.dao;

import com.lovo.hibernate.entity.TeacherEntity;

public interface ITeacherDao {

    public void savaTeacher(TeacherEntity teacher);

    public TeacherEntity getTeacherById(long id);
}
