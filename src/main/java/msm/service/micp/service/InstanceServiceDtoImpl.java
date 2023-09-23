package msm.service.micp.service;

import msm.service.micp.datasource.DataSourceContext;
import msm.service.micp.dto.InstanceDto;
import msm.service.micp.dto.ServiceResponseDTO;
import msm.service.micp.entity.InstanceEntity;
import msm.service.micp.repo.InstanceRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InstanceServiceDtoImpl implements InstanceService {


    @Autowired
    InstanceRepo instanceRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ServiceResponseDTO serviceResponseDTO;

    Map<String, InstanceDto> cachedDataSources = new ConcurrentHashMap<String, InstanceDto>();

    @PostConstruct
    public void initializeDataSource(){

        Optional<List<InstanceEntity>> instancesListOpt = Optional.of(instanceRepo.findAll());
        if(!instancesListOpt.isPresent() || instancesListOpt.get().size() == 0){
            //Logging
        }

        instancesListOpt.get().stream().forEach(instance ->
                cachedDataSources.computeIfAbsent(instance.getInstanceName(), f -> createDataSource(instance))
        );

    }

    @Override
    public ServiceResponseDTO getDataSourceByInstanceName(InstanceEntity instance) {

        InstanceDto requestedDataSource = cachedDataSources.get(instance.getInstanceName());
        if(Objects.isNull(requestedDataSource)){
            serviceResponseDTO.setResponseCode("1F");
            serviceResponseDTO.setResponseDesc("Fail");
            serviceResponseDTO.setPayload(null);
            return serviceResponseDTO;
        }

        serviceResponseDTO.setResponseCode("00");
        serviceResponseDTO.setResponseDesc("Success");
        serviceResponseDTO.setPayload(requestedDataSource);
        return serviceResponseDTO;

    }

    @Override
    public InstanceEntity getInstanceByName(String instanceName) {

        Optional<InstanceEntity> instanceOpt = instanceRepo.findByInstanceNameIgnoreCase(instanceName);
        if(!instanceOpt.isPresent()){
            return null;
        }
        return instanceOpt.get();

    }

    private InstanceDto createDataSource(InstanceEntity instance) {

        return modelMapper.map(instance, InstanceDto.class);

    }
}
