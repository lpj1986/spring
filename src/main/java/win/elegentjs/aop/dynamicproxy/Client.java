package win.elegentjs.aop.dynamicproxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Subject target = new SubjectImpl();

        CustomInvocationHandler customInvocationHandler = new CustomInvocationHandler(target);

        Subject proxy = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[] {Subject.class}, customInvocationHandler);

        proxy.request();

    }
}

