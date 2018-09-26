package win.elegentjs.aop.staticproxy;

public class Client {

    public static void main(String[] args) {
        Subject target = new SubjectImpl();

        Subject proxy = new SubjectProxy(target);

        proxy.request();
    }
}
