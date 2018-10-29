package win.elegentjs.tx;

import java.sql.Connection;

/**
 * Connection ThreadLocal
 */
public class TransactionResourceManager {

    private static ThreadLocal<Connection> resources = new ThreadLocal<Connection>();

    public static Connection getResource() {
        return resources.get();
    }

    public static void bind(Connection resource) {
        resources.set(resource);
    }

    public static Connection unbind() {
        Connection conn = getResource();
        resources.set(null);

        return conn;
    }
}
