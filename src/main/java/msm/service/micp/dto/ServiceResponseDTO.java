package msm.service.micp.dto;

import lombok.Data;

import java.io.Serializable;
import java.rmi.Remote;

@Data
public class ServiceResponseDTO implements Serializable {

    private static final long serialVersionUID = 2L;

    String responseCode;
    String responseDesc;
    Object payload;

}
