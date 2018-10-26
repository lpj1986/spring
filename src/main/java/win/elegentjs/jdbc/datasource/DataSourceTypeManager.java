package win.elegentjs.jdbc.datasource;

public class DataSourceTypeManager {

    private static final ThreadLocal<DataSourceEnum> dataSourceTypes = new ThreadLocal<>();


    public static DataSourceEnum get() {
        return dataSourceTypes.get();
    }

    public static void set(DataSourceEnum dataSourceEnum) {
        dataSourceTypes.set(dataSourceEnum);
    }

    public static void reset() {
        dataSourceTypes.set(DataSourceEnum.MASTER);
    }
}
