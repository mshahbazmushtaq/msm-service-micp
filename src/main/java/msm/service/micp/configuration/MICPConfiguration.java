package msm.service.micp.configuration;

import msm.service.micp.dto.ServiceResponseDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MICPConfiguration {

    @Bean
    public ServiceResponseDTO serviceResponseDTO(){
        return new ServiceResponseDTO();
    }

}
