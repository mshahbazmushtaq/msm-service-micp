package msm.service.micp.service;

import msm.service.micp.dto.ServiceResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstanceServiceConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ServiceResponseDTO serviceResponseDTO() {
        return new ServiceResponseDTO();
    }

    @Bean(name="instanceServiceImpl")
    public InstanceService instanceService() {
        return new InstanceServiceImpl();
    }

    @Bean(name="instanceServiceDtoImpl")
    public InstanceService instanceServiceDto() {
        return new InstanceServiceDtoImpl();
    }

}
