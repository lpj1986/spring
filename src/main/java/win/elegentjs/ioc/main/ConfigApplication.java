package win.elegentjs.ioc.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import win.elegentjs.ioc.CInjection;
import win.elegentjs.ioc.SetterInjection;

public class ConfigApplication {
    private static final Log log = LogFactory.getLog(ConfigApplication.class);

    public static void main(String[] args) {

        BeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:applicationContext.xml");

        // or
        //beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));


        CInjection injection = (CInjection) beanFactory.getBean("cInjection");

        log.debug(injection);


        SetterInjection setterInjection = (SetterInjection) beanFactory.getBean("setterInjection");

        log.debug(setterInjection);


    }
}
