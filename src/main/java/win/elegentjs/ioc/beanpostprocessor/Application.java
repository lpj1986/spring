package win.elegentjs.ioc.beanpostprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import win.elegentjs.ioc.SetterInjection;

public class Application {

    private static final Log log = LogFactory.getLog(Application.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        SetterInjection setterInjection = (SetterInjection) context.getBean("setterInjection");

        log.info(setterInjection);


    }
}
