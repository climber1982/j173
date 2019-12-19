package com.lovo.mvc.observer;

public class USA implements ISpy {

    @Override
    public void getMessage(String message) {
        System.out.println("美国获得消息:"+message);
        System.out.println("美国表示：增兵韩国，制裁朝鲜！！");
    }
}
