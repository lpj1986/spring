package win.elegentjs.aop.advice.introduction;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class DelegatingIntroductionInteceptorTest {

    public static void main(String[] args) {
        Tester delegate = new TesterImpl();

        DelegatingIntroductionInterceptor interceptor = new DelegatingIntroductionInterceptor(delegate);

        ProxyFactory weaver = new ProxyFactory(new DeveloperImpl());

        weaver.addAdvice(interceptor);

        Tester tester = (Tester) weaver.getProxy();

        tester.test();



    }
}
