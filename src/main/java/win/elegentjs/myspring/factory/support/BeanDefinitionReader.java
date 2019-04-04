package win.elegentjs.myspring.factory.support;

import org.springframework.core.io.Resource;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    int loadBeanDefinitions(String path);
}
