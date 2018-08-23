package win.elegentjs.ioc;

public class CInjection {

    private UserService userService;

    public CInjection(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String toString() {
        return "CInjection{" +
                "userService=" + userService +
                '}';
    }
}
