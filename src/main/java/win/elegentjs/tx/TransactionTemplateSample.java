package win.elegentjs.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionTemplateSample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TransactionTemplate transactionTemplate = (TransactionTemplate) context.getBean("transactionTemplate");
        final DataSource dataSource = (DataSource) context.getBean("dataSource");

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                Connection conn = DataSourceUtils.getConnection(dataSource);

                PreparedStatement pstmt;
                try {
                    pstmt = conn.prepareStatement("select * from T_BASE_RESOURCE");
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
