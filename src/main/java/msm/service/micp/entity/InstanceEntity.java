package msm.service.micp.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "instances")
@Data
public class InstanceEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "instance_id")
    Long instanceId;

    @Column(name = "instance_name")
    String instanceName;

    @Column(name = "url")
    String url;

    @Column(name = "user_name", length = 128)
    String userName;

    @Column(name = "password", length = 128)
    String password;

    @Column(name = "driver_class")
    String driverClass;

    @Column(name = "min_pool_size")
    Integer minPoolSize;

    @Column(name = "max_pool_size")
    Integer maxPoolSize;

    @Column(name = "init_pool_size")
    Integer InitPoolSize;

}
