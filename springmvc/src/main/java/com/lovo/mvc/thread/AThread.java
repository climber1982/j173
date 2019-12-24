package com.lovo.mvc.thread;

import java.util.Date;

public class AThread extends  Thread {


    public void run() {
        while (true) {
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
