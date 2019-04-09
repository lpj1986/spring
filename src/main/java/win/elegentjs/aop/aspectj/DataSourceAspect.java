package win.elegentjs.aop.aspectj;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import win.elegentjs.jdbc.datasource.DataSourceContextHolder;
import win.elegentjs.jdbc.datasource.DataSourceEnum;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(0)
public class DataSourceAspect {

        private static final Log log = LogFactory.getLog(DataSourceAspect.class);

        @Pointcut("execution(* win.elegentjs.service.impl.UserServiceImpl.*(..))")
        public void pointCut() {

        }

        @Before("pointCut()")
        public void before(JoinPoint point) {
            Object target = point.getTarget();
            String methodName = point.getSignature().getName();
            Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
            try {
                Method method = target.getClass().getMethod(methodName, parameterTypes);
                if (method != null && method.isAnnotationPresent(Transactional.class)) {
                    DataSourceContextHolder.set(DataSourceEnum.MASTER);
                } else {
                    DataSourceContextHolder.set(DataSourceEnum.SLAVE);
                }
            } catch (Exception e) {
                log.error(String.format("Choose DataSource error, method:%s, msg:%s", methodName, e.getMessage()));
            }

        }

        @After("pointCut()")
        public void after() {
            DataSourceContextHolder.reset();
        }

}
