package msm.service.micp.datasource;

import msm.service.micp.entity.InstanceEntity;

import javax.sql.DataSource;

public class DataSourceContext {

    DataSourceStrategy strategy;

    public DataSourceContext(DataSourceStrategy strategy){
        this.strategy = strategy;
    }

    public DataSource getDataSource(InstanceEntity instance){
        return strategy.getDataSource(instance);
    }

}
