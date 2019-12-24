package com.lovo.mvc.thread;

public class BThread implements Runnable {


    public void run() {

         for(int i=0;i<10;i++){
             System.out.println("我是普通线程。。。"+i);
             try {
                 Thread.sleep(1000*2);
             } catch (InterruptedException e) {

             }
         }
    }
}
