package win.elegentjs.transaction;

import org.springframework.transaction.*;
import org.springframework.transaction.support.DefaultTransactionStatus;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 自定义JDBC事务管理器
 */
public class JdbcTransactionManager  implements PlatformTransactionManager {

    private DataSource dataSource;

    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
        Connection conn;


        try {
            conn = dataSource.getConnection();
            TransactionResourceManager.bind(conn);

            return new DefaultTransactionStatus(conn, true, true, false, true, null);

        } catch (SQLException e) {
            throw new CannotCreateTransactionException(e.getMessage(), e);
        }

    }

    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        Connection conn = TransactionResourceManager.unbind();

        try {
            conn.commit();
        } catch (SQLException e) {
            throw new TransactionSystemException(e.getMessage(), e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionException {
        Connection conn = TransactionResourceManager.unbind();

        try {
            conn.rollback();
        } catch (SQLException e) {
            throw new UnexpectedRollbackException(e.getMessage(), e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
