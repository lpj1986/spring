package win.elegentjs.ioc.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
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

        // PropertyPlaceholderConfigurer bean post processor
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("appconfig.properties"));
        propertyPlaceholderConfigurer.postProcessBeanFactory((DefaultListableBeanFactory) beanFactory);


        // PropertyOverrideConfigurer bean post processor
        PropertyOverrideConfigurer overrideConfigurer = new PropertyOverrideConfigurer();
        overrideConfigurer.setLocation(new ClassPathResource("override.properties"));
        overrideConfigurer.postProcessBeanFactory((DefaultListableBeanFactory) beanFactory);


        CInjection injection = (CInjection) beanFactory.getBean("cInjection");

        log.debug(injection);


        SetterInjection setterInjection = (SetterInjection) beanFactory.getBean("setterInjection");

        log.debug(setterInjection);


    }
}
