package win.elegentjs.jdbc.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 可动态改变的dataSource
 *
 * @author liupeijun
 *
 */
public class RoutingDataSource extends AbstractRoutingDataSource {


    private DataSource masterDataSource;

    private DataSource slaveDataSource;

    @Override
    public void afterPropertiesSet() {
        if (this.masterDataSource == null) {
            throw new IllegalArgumentException("Property 'writeDataSource' is required");
        }
        setDefaultTargetDataSource(masterDataSource);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceEnum.MASTER.name(), masterDataSource);
        targetDataSources.put(DataSourceEnum.SLAVE.name(), slaveDataSource);

        setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }


    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceEnum dataSourceEnum = DataSourceContextHolder.get();

        if(dataSourceEnum == null
                || dataSourceEnum == DataSourceEnum.MASTER) {
            return DataSourceEnum.MASTER.name();
        }

        return dataSourceEnum.name();
    }


    public DataSource getMasterDataSource() {
        return masterDataSource;
    }

    public void setMasterDataSource(DataSource masterDataSource) {
        this.masterDataSource = masterDataSource;
    }

    public DataSource getSlaveDataSource() {
        return slaveDataSource;
    }

    public void setSlaveDataSource(DataSource slaveDataSource) {
        this.slaveDataSource = slaveDataSource;
    }
}
