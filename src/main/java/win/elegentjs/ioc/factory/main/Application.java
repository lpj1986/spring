package win.elegentjs.ioc.factory.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import win.elegentjs.ioc.factory.Shape;

public class Application {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:applicationContext.xml");

        Shape shape = (Shape) beanFactory.getBean("shape");
        System.out.println(shape);


        shape = (Shape) beanFactory.getBean("shape2");
        System.out.println(shape);
    }
}
