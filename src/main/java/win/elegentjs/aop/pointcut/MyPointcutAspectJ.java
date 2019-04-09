package win.elegentjs.aop.pointcut;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import win.elegentjs.myspring.sample.OrgService;
import win.elegentjs.myspring.sample.impl.OrgServiceImpl;
import win.elegentjs.service.impl.UserServiceImpl;

public class MyPointcutAspectJ {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();

        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression("execution(* win.elegentjs.myspring..impl.OrgServiceImpl.*(..))");
        advisor.setAdvice(new LogInteceptor());

        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new OrgServiceImpl());
        proxyFactory.setInterfaces(OrgService.class);
        OrgService o = (OrgService) proxyFactory.getProxy();

        System.out.println(o.get(""));
    }

}


class LogInteceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("start");

        Object result =  invocation.proceed();

        System.out.println("end");
        return result;
    }
}
