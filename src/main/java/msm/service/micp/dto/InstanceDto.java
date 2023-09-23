package msm.service.micp.dto;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
public class InstanceDto {

    Long instanceId;
    String instanceName;
    String url;
    String userName;
    String password;
    String driverClass;
    Integer minPoolSize;
    Integer maxPoolSize;
    Integer InitPoolSize;

}
