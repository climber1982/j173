package com.lovo.mvc.observer;

public class Main {

    public static void main(String[] args) {
        //创建被观察者
        IKorea korea=new Korea();
        //创建观察者
        ISpy china=new China();
        ISpy russia=new Russia();
        ISpy usa=new USA();

        //添加间谍到被观察者
        korea.addSpy(china);
        korea.addSpy(usa);
        korea.addSpy(russia);
        //删除观察者
           korea.delSpy(russia);
        //朝鲜搞事情
        korea.seadMissile(1);
    }
}
