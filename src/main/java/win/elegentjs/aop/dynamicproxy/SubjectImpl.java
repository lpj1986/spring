package win.elegentjs.aop.dynamicproxy;

public class SubjectImpl implements Subject {
    @Override
    public void request() {
        System.out.println("hello, static proxy. ");
    }
}
