package com;

import com.lovo.spring.service.ICatService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCat {

    @Test
    public void eat(){
        ClassPathXmlApplicationContext app
                =new ClassPathXmlApplicationContext("cat.xml");
    ICatService service= (ICatService) app.getBean("catService");
     service.eat("鱼");
    }
}
