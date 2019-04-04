package win.elegentjs.myspring.config;

public class DefaultBeanDefinition implements BeanDefinition {

    private String beanClassName;

    @Override
    public String getBeanClassName() {
        return beanClassName;
    }

    @Override
    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }
}
