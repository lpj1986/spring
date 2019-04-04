package win.elegentjs.myspring.factory.support;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import win.elegentjs.myspring.config.BeanDefinition;
import win.elegentjs.myspring.config.DefaultBeanDefinition;

import java.util.Locale;

public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    private BeanDefinitionRegistry registry;

    private ResourceBundleMessageSource messageSource;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;

    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public int loadBeanDefinitions(String path) {
        messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(path);

        BeanDefinition beanDefinition = new DefaultBeanDefinition();
        beanDefinition.setBeanClassName(getMsg("class"));

        getRegistry().registerBeanDefinition(getMsg("beanId"), beanDefinition);

        return 1;
    }


    private String getMsg(String key) {
        return messageSource.getMessage(key, new Object[]{}, Locale.getDefault());
    }
}
