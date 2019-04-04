package win.elegentjs.myspring.factory;

import org.springframework.core.io.ClassPathResource;
import win.elegentjs.myspring.factory.support.BeanDefinitionReader;
import win.elegentjs.myspring.factory.support.XmlBeanDefinitionReader;

public class XmlBeanFactory extends DefaultListableBeanFactory {

    private BeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(this);

    public XmlBeanFactory(String xmlConfigPath) {
        super();
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlConfigPath);
    }
}
