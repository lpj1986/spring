package win.elegentjs.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        FooService fooService = (FooService) applicationContext.getBean("fooService");

        fooService.serviceMethod();
    }
}
