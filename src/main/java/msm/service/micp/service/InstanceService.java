package msm.service.micp.service;

import msm.service.micp.dto.ServiceResponseDTO;
import msm.service.micp.entity.InstanceEntity;


public interface InstanceService {

    ServiceResponseDTO getDataSourceByInstanceName(InstanceEntity instance);
    InstanceEntity getInstanceByName(String instanceName);

}
