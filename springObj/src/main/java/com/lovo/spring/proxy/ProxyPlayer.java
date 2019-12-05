package com.lovo.spring.proxy;

/**
 * 代练--代理
 */
public class ProxyPlayer implements IPlayer  {

    //持有玩家
    IPlayer player;

    public ProxyPlayer(IPlayer player){
        this.player=player;
    }

    public String play() {
        System.out.println("代练前");
        long start= System.currentTimeMillis();
        //玩家的等级
        player.play();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("代练后");
        return "最强王者";
    }
}
