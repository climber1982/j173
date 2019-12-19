package com.lovo.mvc.observer;

import java.util.ArrayList;
import java.util.List;

public class Korea implements IKorea {
   //间谍集合
    List<ISpy> spyList=new ArrayList<>();
    public void addSpy(ISpy spy) {
        spyList.add(spy);
    }

    @Override
    public void delSpy(ISpy spy) {
      spyList.remove(spy);
    }

    @Override
    public void seadMissile(int tag) {
         if(tag==1){
             //所有间谍获得消息
             this.notifySpy("朝鲜已经发射了远程导弹");
         }
    }

    @Override
    public void notifySpy(String message) {

        for (ISpy spy:spyList) {
            spy.getMessage(message);
        }

    }
}
