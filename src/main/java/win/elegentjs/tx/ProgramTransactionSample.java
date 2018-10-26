package win.elegentjs.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProgramTransactionSample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) context.getBean("transactionManager");
        DataSource dataSource = (DataSource) context.getBean("dataSource");

        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();

        TransactionStatus status = transactionManager.getTransaction(definition);

        Connection conn = DataSourceUtils.getConnection(dataSource);

        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from T_BASE_RESOURCE");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
        } finally {
            transactionManager.commit(status);
        }


    }
}
