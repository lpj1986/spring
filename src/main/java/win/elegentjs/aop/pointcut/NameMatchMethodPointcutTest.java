package win.elegentjs.aop.pointcut;

import org.springframework.aop.support.NameMatchMethodPointcut;

public class NameMatchMethodPointcutTest {

    public static void main(String[] args) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("matches");

        pointcut.setMappedNames(new String[] {"matches", "isRuntime"});


    }
}
