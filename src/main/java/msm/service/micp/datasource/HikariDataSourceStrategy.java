package msm.service.micp.datasource;

import com.zaxxer.hikari.HikariDataSource;
import msm.service.micp.entity.InstanceEntity;

import javax.sql.DataSource;

public class HikariDataSourceStrategy implements DataSourceStrategy {

    @Override
    public DataSource getDataSource(InstanceEntity instanceEntity) {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(instanceEntity.getDriverClass());
        dataSource.setJdbcUrl(instanceEntity.getUrl());
        dataSource.setUsername(instanceEntity.getUserName());
        dataSource.setPassword(instanceEntity.getPassword());
        dataSource.setMaximumPoolSize(instanceEntity.getMaxPoolSize());

        return dataSource;
    }

}
