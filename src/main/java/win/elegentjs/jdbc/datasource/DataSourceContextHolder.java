package win.elegentjs.jdbc.datasource;

/**
 * 持有ThreadLocal的枚举类型类
 *
 * @author liupeijun
 */
public class DataSourceContextHolder {

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
