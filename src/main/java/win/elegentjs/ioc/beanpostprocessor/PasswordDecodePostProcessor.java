package win.elegentjs.ioc.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PasswordDecodePostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof PasswordDecodable) {
            String encodePassword = ((PasswordDecodable) bean).getEncodedPassword();
            String decodedPassword = decode(encodePassword);

            ((PasswordDecodable) bean).setDecodedPassword(decodedPassword);
        }

        return bean;
    }
    

    private String decode(String encodePassword) {
        return encodePassword + ": 123";
    }
}
