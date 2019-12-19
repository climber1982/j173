package com.lovo.mvc.observer;

public class Russia implements ISpy {

    @Override
    public void getMessage(String message) {
        System.out.println("俄罗斯获得消息:"+message);
        System.out.println("俄罗表示：支持裁朝鲜！！");
    }
}
