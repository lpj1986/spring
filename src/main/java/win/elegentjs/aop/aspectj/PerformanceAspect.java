package win.elegentjs.aop.aspectj;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class PerformanceAspect {

    private static final Log log = LogFactory.getLog(PerformanceAspect.class);

    @Pointcut("execution(* win..PerformanceService.*(..))")
    public void pointcutName() {

    }

    @Around("pointcutName()")
    public Object performance(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        try {
            stopWatch.start();

            return joinPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info(stopWatch.toString());
        }
    }
}
