package win.elegentjs.transaction;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FooService {

    private PlatformTransactionManager transactionManager;

    public void serviceMethod() {
        TransactionDefinition definition = null;

        TransactionStatus transactionStatus = transactionManager.getTransaction(definition);

        try {

            Connection conn = TransactionResourceManager.getResource();
            PreparedStatement pstmt = conn.prepareStatement("select * from T_BASE_RESOURCE");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }



        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
        }

        transactionManager.commit(transactionStatus);
    }


    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
