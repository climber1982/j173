package com.lovo.mvc.observer;

import java.util.List;

/**
 * 被观察者朝鲜
 */
public interface IKorea {
    /**
     * 添加间谍
     * @param spy
     */
    public  void addSpy(ISpy spy);

    /**
     * 删除间谍
     * @param spy
     */
    public  void delSpy(ISpy spy);

    /**
     * 发送导弹
     * @param tag 0-发送短程导弹，1-发送远程导弹
     */
    public  void seadMissile(int tag);

    /**
     * 通知所有鉴定
     * @param message
     */
    public  void notifySpy(String message);
}
