package win.elegentjs.ioc;

import win.elegentjs.ioc.beanpostprocessor.PasswordDecodable;

public class UserService implements PasswordDecodable {

    private String name;

    private Integer age;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getEncodedPassword() {
        return password;
    }

    @Override
    public void setDecodedPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
