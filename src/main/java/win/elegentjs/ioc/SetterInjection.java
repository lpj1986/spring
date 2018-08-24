package win.elegentjs.ioc;

import java.util.List;

public class SetterInjection {

    private UserService userService;

    private List<String> nameList;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    @Override
    public String toString() {
        return "SetterInjection{" +
                "userService=" + userService +
                ", nameList=" + nameList +
                '}';
    }
}
