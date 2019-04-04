package win.elegentjs.myspring.factory.support;

import win.elegentjs.myspring.config.BeanDefinition;

/**
 * BeanDefinition注册接口
 *
 * 当BeanDefinition实例创建好后往BeanDefinition注册处进行注册
 *
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
