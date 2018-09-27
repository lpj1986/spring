package win.elegentjs.aop.advisor;

import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * Spring AOP 要素
 *
 *  Advisor:
 *
 *      Advice
 *      Pointcut
 *
 *  织入器：ProxyFactory
 *
 */
public class Main {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProxyFactory proxyFactory = (ProxyFactory) context.getBean("proxyFactory");
        PointcutAdvisor advisor = (PointcutAdvisor) context.getBean("advisor");

        proxyFactory.addAdvisor(advisor);


        PerformanceService performanceService = (PerformanceService) context.getBean("performanceService");

        proxyFactory.setTarget(performanceService);

        performanceService = (PerformanceService) proxyFactory.getProxy();

        performanceService.printService();

    }
}
