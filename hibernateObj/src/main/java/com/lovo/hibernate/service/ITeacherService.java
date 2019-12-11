package com.lovo.hibernate.service;

import com.lovo.hibernate.entity.TeacherEntity;

public interface ITeacherService {

    public void savaTeacher(TeacherEntity teacher);

    public TeacherEntity getTeacherById(long id);
}
