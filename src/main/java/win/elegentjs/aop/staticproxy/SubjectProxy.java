package win.elegentjs.aop.staticproxy;

public class SubjectProxy implements Subject {

    private Subject target;

    public SubjectProxy(Subject subject) {
        this.target = subject;
    }

    @Override
    public void request() {
        System.out.println("before target execute.");

        target.request();

        System.out.println("after target execute.");
    }
}
