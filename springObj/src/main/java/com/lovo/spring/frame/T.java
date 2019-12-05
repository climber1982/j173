package com.lovo.spring.frame;

import com.lovo.spring.frame.user.User;

public class T {
    public static void main(String[] args) {
        IMessage message=new User();
        //创建框架
        IAnima anima=new Anima();
        //调用框架的方法
       // anima.eat(new User());
        anima.eat(message);
    }
}
