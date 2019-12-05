package com.lovo.spring.frame.user;

import com.lovo.spring.frame.IMessage;

public class User implements IMessage {

    @Override
    public String createMessage() {
        return "dog";
    }
}
