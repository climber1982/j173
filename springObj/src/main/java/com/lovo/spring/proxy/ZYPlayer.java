package com.lovo.spring.proxy;

public class ZYPlayer implements IPlayer {


    public String play() {

        System.out.println("玩家是一个黄金级别");
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "黄金级别";
    }
}
