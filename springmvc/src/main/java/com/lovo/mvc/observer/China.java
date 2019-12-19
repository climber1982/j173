package com.lovo.mvc.observer;

public class China implements ISpy {


    public void getMessage(String message) {
        System.out.println("中国获得消息:"+message);
        System.out.println("中国表示：保持克制！！");
    }
}
