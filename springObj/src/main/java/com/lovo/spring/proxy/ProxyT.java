package com.lovo.spring.proxy;

import com.lovo.spring.proxy.user.PlayerHandler;

import java.lang.reflect.Proxy;

public class ProxyT {

    public static void main(String[] args) {
        //被代理者
        IPlayer player=new ZYPlayer();
        player= (IPlayer) Proxy.newProxyInstance(IPlayer.class.getClassLoader(),new Class[]{IPlayer.class}
        ,new PlayerHandler(player));
      player.eat();
    }
}
