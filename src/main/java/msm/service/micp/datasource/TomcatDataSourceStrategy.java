package msm.service.micp.datasource;

import msm.service.micp.entity.InstanceEntity;

import javax.sql.DataSource;

public class TomcatDataSourceStrategy implements DataSourceStrategy {

    @Override
    public DataSource getDataSource(InstanceEntity instanceEntity) {

        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName(instanceEntity.getDriverClass());
        dataSource.setUrl(instanceEntity.getUrl());
        dataSource.setUsername(instanceEntity.getUserName());
        dataSource.setPassword(instanceEntity.getPassword());
        dataSource.setInitialSize(instanceEntity.getInitPoolSize());

        return dataSource;
    }

}
