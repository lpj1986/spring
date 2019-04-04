package win.elegentjs.myspring.factory;

/**
 * Bean 工厂接口
 *
 * @author liupeijun
 */
public interface BeanFactory {

   <T> T getBean(String beanName, Class<T> clazz);


}
