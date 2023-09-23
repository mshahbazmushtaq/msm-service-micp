package msm.service.micp.repo;

import msm.service.micp.entity.InstanceEntity;
import msm.service.micp.exception.InstanceNotConfiguredException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstanceRepo extends JpaRepository<InstanceEntity, Long> {

    Optional<InstanceEntity> findByInstanceNameIgnoreCase(String instanceName);

}
