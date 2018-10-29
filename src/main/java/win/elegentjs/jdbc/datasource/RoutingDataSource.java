package win.elegentjs.jdbc.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.logging.Logger;

/**
 * 可动态改变的dataSource
 *
 * @author liupeijun
 *
 */
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceTypeManager.get();
    }

    @Override
    public Logger getParentLogger() {
        return null;
    }
}
