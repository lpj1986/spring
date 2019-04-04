package win.elegentjs.myspring.factory;

import win.elegentjs.myspring.config.BeanDefinition;
import win.elegentjs.myspring.factory.support.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缺省BeanFactory
 */
public class DefaultListableBeanFactory implements BeanFactory, BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>(128);

    private Map<String, Object> beanMap = new ConcurrentHashMap<>(128);

    public DefaultListableBeanFactory() {

    }

    @Override
    public <T> T getBean(String beanName, Class<T> clazz) {

        if (beanMap.containsKey(beanName)) {
            return (T) beanMap.get(beanName);
        }


        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if(beanDefinition == null) {
            throw new IllegalStateException("cannot find bean :[" + beanName + "]" );
        }

        String className = beanDefinition.getBeanClassName();
        try {

            T instance = (T)Class.forName(className).newInstance();

            registerSingleton(beanName, instance);

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        throw new IllegalStateException("get Bean false");
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }


    private void registerSingleton(String beanName, Object instance) {
        beanMap.put(beanName, instance);
    }
}
