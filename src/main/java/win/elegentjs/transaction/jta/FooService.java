package win.elegentjs.transaction.jta;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

public class FooService {

    private PlatformTransactionManager transactionManager;

    public void serviceMethod() {
        TransactionDefinition definition = null;

        TransactionStatus transactionStatus = transactionManager.getTransaction(definition);

        try {
            // TODO ...

        } catch (DataAccessException e) {
            transactionManager.rollback(transactionStatus);
        }

        transactionManager.commit(transactionStatus);
    }


    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
