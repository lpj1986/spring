package win.elegentjs.aop.cglibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;

public class Client {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();


        enhancer.setSuperclass(SubjectImpl.class);

        enhancer.setCallback(new MyInterceptor());

        SubjectImpl subject = (SubjectImpl) enhancer.create();

        subject.request();
    }
}
