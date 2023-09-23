package msm.service.micp.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import msm.service.micp.entity.InstanceEntity;

import javax.sql.DataSource;

public class C3P0DataSourceStrategy implements DataSourceStrategy {

    @Override
    public DataSource getDataSource(InstanceEntity instanceEntity) {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try{
            dataSource.setDriverClass(instanceEntity.getDriverClass());
            dataSource.setJdbcUrl(instanceEntity.getUrl());
            dataSource.setUser(instanceEntity.getUserName());
            dataSource.setPassword(instanceEntity.getPassword());
            dataSource.setInitialPoolSize(instanceEntity.getInitPoolSize());
            dataSource.setMinPoolSize(instanceEntity.getMinPoolSize());
            dataSource.setMaxPoolSize(instanceEntity.getMaxPoolSize());

        } catch (Exception e){

        }

        return dataSource;
    }

}
