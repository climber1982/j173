package com.lovo.spring.frame;

public class Anima implements IAnima {

    public void eat(IMessage message) {
      //获得用户给我的信息
        String info=message.createMessage();
        if(info.equals("dog")){
            System.out.println("旺财正在吃骨头");
        }else if(info.equals("cat")){
            System.out.println("小花正在吃鱼");
        }else {
            System.out.println("你输入的动物暂时不存在");
        }
    }
}
