package com.lovo.spring.proxy;

public class T {

    public static void main(String[] args) {
        //创建玩家
       IPlayer player=new ZYPlayer();
      // player.play();
//        IPlayer player=new ZFPlayer();
        //创建代理
        player=new ProxyPlayer(player);
        //调用代理
     String str=   player.play();
        System.out.println(str);
    }
}
