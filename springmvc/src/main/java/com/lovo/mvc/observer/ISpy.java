package com.lovo.mvc.observer;

/**
 * 观察者接口，间谍
 */
public interface ISpy {
    /**
     * 间谍获得消息
     * @param message
     */
    public  void getMessage(String message);
}
