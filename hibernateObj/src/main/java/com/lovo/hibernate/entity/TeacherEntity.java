package com.lovo.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sys_teacher")
public class TeacherEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "t_id")
    private  long teacherId;
    @Column(name = "t_name",length = 48)
    private String teacherName;
   @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)//交给多的一方去维护，mappedBy=“维护实体的引用”
    Set<StudentEntity> stuSet;

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Set<StudentEntity> getStuSet() {
        return stuSet;
    }

    public void setStuSet(Set<StudentEntity> stuSet) {
        this.stuSet = stuSet;
    }
}
