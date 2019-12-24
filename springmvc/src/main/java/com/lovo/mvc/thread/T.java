package com.lovo.mvc.thread;

public class T {

    public static void main(String[] args) {

        AThread a=new AThread();
        BThread b=new BThread();
        //把a设置为守护式线程
        a.setDaemon(true);
        //启动线程
        a.start();
        new Thread(b).start();

    }
}
