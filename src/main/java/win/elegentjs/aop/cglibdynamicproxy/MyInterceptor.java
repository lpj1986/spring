package win.elegentjs.aop.cglibdynamicproxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        if ("request".equals(method.getName())) {
            System.out.println("before invoke.");
            return methodProxy.invokeSuper(o, objects);
        }

        return null;
    }
}
