package win.elegentjs.aop.jdkdynamicproxy;

public class SubjectImpl implements Subject {

    @Override
    public void request() {
        System.out.println("hello, static proxy. ");
    }
}
