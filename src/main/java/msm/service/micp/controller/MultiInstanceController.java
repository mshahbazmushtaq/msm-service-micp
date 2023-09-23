package msm.service.micp.controller;

import msm.service.micp.dto.ServiceResponseDTO;
import msm.service.micp.entity.InstanceEntity;
import msm.service.micp.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("micp")
public class MultiInstanceController {

    @Autowired
    @Qualifier("instanceServiceDtoImpl")
    InstanceService instanceService;

    @Autowired
    ServiceResponseDTO serviceResponseDTO;

    @GetMapping("/instance/{name}")
    public ServiceResponseDTO getInstanceConnection(@PathVariable("name") String instanceName){

        InstanceEntity instance = instanceService.getInstanceByName(instanceName);
        if(Objects.isNull(instance)){
            serviceResponseDTO.setResponseCode("INC");
            serviceResponseDTO.setResponseDesc("Instance not configured!");
            serviceResponseDTO.setPayload(null);
            return serviceResponseDTO;
        }

        return instanceService.getDataSourceByInstanceName(instance);

    }

}
