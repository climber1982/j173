package com.lovo.spring.proxy;

public class ZFPlayer implements IPlayer {

    @Override
    public String play() {
        System.out.println("张飞的级别是铂金");
        return "铂金";
    }

    @Override
    public void eat() {

    }
}
