package msm.service.micp.datasource;

import msm.service.micp.entity.InstanceEntity;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DBCPDataSourceStrategy implements DataSourceStrategy {

    @Override
    public DataSource getDataSource(InstanceEntity instanceEntity) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(instanceEntity.getDriverClass());
        dataSource.setUrl(instanceEntity.getUrl());
        dataSource.setUsername(instanceEntity.getUserName());
        dataSource.setPassword(instanceEntity.getPassword());
        //dataSource.setClearStatementPoolOnReturn(Boolean.valueOf(true));
        //dataSource.setInitialSize(1);
        //dataSource.setMaxTotal(instanceEntity.getMaxPoolSize());

        return dataSource;
    }

}
