package msm.service.micp.datasource;

import msm.service.micp.entity.InstanceEntity;

import javax.sql.DataSource;

public interface DataSourceStrategy {

    DataSource getDataSource(InstanceEntity instanceEntity);

}
