package win.elegentjs.aop.advice;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import win.elegentjs.myspring.sample.OrgService;
import win.elegentjs.myspring.sample.impl.OrgServiceImpl;

public class Main {

    public static void main(String[] args) {
        OrgService orgService = new OrgServiceImpl();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(OrgService.class);
        proxyFactory.setTarget(orgService);

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* win.elegentjs.myspring..impl.OrgServiceImpl.*(..))");
        advisor.setAdvice(new PerformanceInterceptor());
        advisor.setPointcut(pointcut);

        proxyFactory.addAdvisor(advisor);

        OrgService proxy = (OrgService) proxyFactory.getProxy();

        proxy.get("");


    }
}
