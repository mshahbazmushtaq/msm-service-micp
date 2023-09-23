package msm.service.micp.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSourceContext dataSourceContext(@Value("${datasource.strategy}") String strategy) {
        DataSourceStrategy dataSourceStrategy;
        switch (strategy.toLowerCase()) {
            case "hikari":
                dataSourceStrategy = new HikariDataSourceStrategy();
                break;
            case "tomcat":
                dataSourceStrategy = new TomcatDataSourceStrategy();
                break;
            case "c3p0":
                dataSourceStrategy = new C3P0DataSourceStrategy();
                break;
            case "dbcp":
                dataSourceStrategy = new DBCPDataSourceStrategy();
                break;
            default:
                throw new IllegalArgumentException("Invalid datasource strategy");
        }

        return new DataSourceContext(dataSourceStrategy);
    }

}
