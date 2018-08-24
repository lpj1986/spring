package win.elegentjs.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ConfigApplication {
    private static final Log log = LogFactory.getLog(ConfigApplication.class);

    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        CInjection injection = (CInjection) beanFactory.getBean("cInjection");

        log.debug(injection);


        SetterInjection setterInjection = (SetterInjection) beanFactory.getBean("setterInjection");

        log.debug(setterInjection);


    }
}
