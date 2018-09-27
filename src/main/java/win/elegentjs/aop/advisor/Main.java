package win.elegentjs.aop.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PerformanceService performanceService = (PerformanceService) context.getBean("performanceService");

        performanceService.printService();

    }
}
