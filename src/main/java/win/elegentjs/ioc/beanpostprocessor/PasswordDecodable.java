package win.elegentjs.ioc.beanpostprocessor;

public interface PasswordDecodable {

    String getEncodedPassword();

    void setDecodedPassword(String password);
}
