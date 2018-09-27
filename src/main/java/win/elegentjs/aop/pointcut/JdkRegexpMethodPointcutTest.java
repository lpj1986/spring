package win.elegentjs.aop.pointcut;

import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class JdkRegexpMethodPointcutTest {

    public static void main(String[] args) {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".+match");
    }
}
