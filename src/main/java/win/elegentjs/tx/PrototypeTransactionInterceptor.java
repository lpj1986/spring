package win.elegentjs.tx;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author liupeijun
 */
public class PrototypeTransactionInterceptor implements MethodInterceptor {

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        TransactionDefinition definition = new DefaultTransactionDefinition();

        TransactionStatus status = transactionManager.getTransaction(definition);

        Object result;

        try {
            result = invocation.proceed();
        } catch (Throwable t) {
            transactionManager.rollback(status);
            throw t;
        }

        transactionManager.commit(status);

        return result;
    }
}
