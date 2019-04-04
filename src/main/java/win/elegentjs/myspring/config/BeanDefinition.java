package win.elegentjs.myspring.config;

public interface BeanDefinition {

    /**
     * 获取Bean类完全限定名
     * @return
     */
    String getBeanClassName();

    /**
     * 设置Bean类完全限定名
     * @param beanClassName
     */
    void setBeanClassName(String beanClassName);


}
