package win.elegentjs.aop.advisor;

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


        PerformanceService performanceService = (PerformanceService) context.getBean("performanceService");
        performanceService.printService();


        // 采用容器ProxyFactoryBean的形式
        //performanceService = (PerformanceService) context.getBean("proxy");
        //performanceService.printService();

    }
}
