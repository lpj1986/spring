package win.elegentjs.ioc;

public class SetterInjection {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String toString() {
        return "SetterInjection{" +
                "userService=" + userService +
                '}';
    }
}
