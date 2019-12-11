package com.hibernate;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.dao.IUserDao;
import com.lovo.hibernate.entity.*;
import com.lovo.hibernate.service.IStudentService;
import com.lovo.hibernate.service.ITeacherService;
import com.lovo.hibernate.service.IUserService;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

public class TestH {
   @Test
    public void t(){
       //启动spring
       ClassPathXmlApplicationContext applicationContext
               =new ClassPathXmlApplicationContext("application.xml");
   }
    @Test
    public void  savaUser(){
        //启动spring
        ClassPathXmlApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("application.xml");
//        //获得DAO
//     IUserDao userDao= (IUserDao) applicationContext.getBean("userDao");
        //创建用户对象
        UserEntity userEntity=new UserEntity();
        userEntity.setUserName("关羽7");
        userEntity.setUserAge(30);
        userEntity.setDateTime("2019-11-12");
     IUserService userService= (IUserService) applicationContext.getBean("userService");
      userService.savaUser(userEntity);
        //保存
       // userDao.savaUser(userEntity);

    }

@Test
  public  void getUserById(){
    //启动spring
    ClassPathXmlApplicationContext applicationContext
            =new ClassPathXmlApplicationContext("application.xml");
    //获得DAO
    IUserDao userDao= (IUserDao) applicationContext.getBean("userDao");
   UserEntity user= userDao.getUserById("1a");
    System.out.println(user.getUserName());
  }

  @Test
  public  void sava2(){
      //启动spring
      ClassPathXmlApplicationContext applicationContext
              =new ClassPathXmlApplicationContext("application.xml");
      //获得DAO
      IUserDao userDao= (IUserDao) applicationContext.getBean("userDao");
      UserEntity userEntity=new UserEntity();
      userEntity.setUserName("关羽-2");
      userEntity.setUserAge(30);
      userEntity.setDateTime("2019-11-12");
      userDao.savaUser2(userEntity);
  }

  @Test
  public  void updateUser(){
      //启动spring
      ClassPathXmlApplicationContext applicationContext
              =new ClassPathXmlApplicationContext("application.xml");
      //获得DAO
      IUserDao userDao= (IUserDao) applicationContext.getBean("userDao");
      userDao.updateUser("4028815e6ee9ebf1016ee9ec16160000");
  }

  @Test
    public  void getUser(){
      //启动spring
      ClassPathXmlApplicationContext applicationContext
              =new ClassPathXmlApplicationContext("application.xml");
      //获得DAO
      IUserDao userDao= (IUserDao) applicationContext.getBean("userDao");
      userDao.getUser("4028815e6ee9ebf1016ee9ec16160000");
    }
    @Test
    public  void savaStudent(){
        //启动spring
        ClassPathXmlApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("application.xml");

     ITeacherService teacherService= (ITeacherService) applicationContext.getBean("teacherService");
        IStudentService studentService=(IStudentService)applicationContext.getBean("studentService");
        //保存教师
        TeacherEntity t=new TeacherEntity();
        t.setTeacherName("陈老师");
        teacherService.savaTeacher(t);
        //保存学生
        StudentEntity s=new StudentEntity();
        s.setStudentName("赵云");
        s.setTeacher(t);
        studentService.savaStudent(s);
        StudentEntity s1=new StudentEntity();
        s1.setStudentName("马超");
        s1.setTeacher(t);
        studentService.savaStudent(s1);
    }

    @Test
     public void findStudent(){
        //启动spring
        ClassPathXmlApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("application.xml");

        IStudentService studentService=(IStudentService)applicationContext.getBean("studentService");
       StudentEntity studentEntity=   studentService.getStudentById(2);
     // System.out.println(studentEntity.getStudentName()+"/"+studentEntity.getTeacher().getTeacherName());
    }

    @Test
    public void findTeacher(){
        //启动spring
        ClassPathXmlApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("application.xml");

        ITeacherService teacherService= (ITeacherService) applicationContext.getBean("teacherService");
         teacherService.getTeacherById(1);
    }

    @Test
    public  void findRoleName(){
        //启动spring
        ClassPathXmlApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("application.xml");
        IUserService userService= (IUserService) applicationContext.getBean("userService");
        List<String> list=  userService.getRoleListByUserId("1",1);
        for (String str:list) {
            System.out.println(str);
        }
    }
    @Test
    public  void manytomany(){
        //启动spring
        ClassPathXmlApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("application.xml");
     BasicDAO basicDAO= (BasicDAO) applicationContext.getBean("basicDAO");
       Session s=basicDAO.getOpenSession();
        PersonEntity p=      s.get(PersonEntity.class,1l);
        //获得用户拥有的猫
       Set<CatEntity> set= p.getCats();
       for(CatEntity cat:set){
           System.out.println(cat.getCatName());
       }
       s.close();
   }


}
