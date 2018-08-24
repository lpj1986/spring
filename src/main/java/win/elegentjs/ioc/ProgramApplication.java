package win.elegentjs.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * 以编码方式将bean注册到IOC容器
 */
public class ProgramApplication {

    private static final Log log = LogFactory.getLog(ProgramApplication.class);

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        register(beanFactory);

        // setter Injection
        SetterInjection setterInjection = (SetterInjection) beanFactory.getBean("setterInjection");
        log.debug(setterInjection);

        // constructor Injection
        CInjection injection = (CInjection) beanFactory.getBean("cInjection");
        log.debug(injection);

    }


    /**
     * 以编程方式注册bean以及bean之间的依赖
     * @param registry
     */
    private static void register(DefaultListableBeanFactory registry) {
        AbstractBeanDefinition  userService = new RootBeanDefinition(UserService.class);
        userService.setScope(RootBeanDefinition.SCOPE_SINGLETON);
        registry.registerBeanDefinition("userService", userService);


        // setter 注入
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userService", userService));

        AbstractBeanDefinition  setterInjection = new RootBeanDefinition(SetterInjection.class);
        setterInjection.setScope(RootBeanDefinition.SCOPE_SINGLETON);
        registry.registerBeanDefinition("setterInjection", setterInjection);

        setterInjection.setPropertyValues(propertyValues);

        // 构造器注入
        ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
        argumentValues.addIndexedArgumentValue(0, userService);

        AbstractBeanDefinition  cInjection = new RootBeanDefinition(CInjection.class);
        cInjection.setScope(RootBeanDefinition.SCOPE_SINGLETON);
        registry.registerBeanDefinition("cInjection", cInjection);

        cInjection.setConstructorArgumentValues(argumentValues);
    }

}
