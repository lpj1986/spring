package win.elegentjs.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/**
 * Around Advice
 */
public class PerformanceInterceptor implements MethodInterceptor {

    private static final Log log = LogFactory.getLog(PerformanceInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        try {
            stopWatch.start();

            invocation.proceed();
        } finally {
            stopWatch.stop();

            log.info(stopWatch.toString());
        }

        return null;
    }
}
