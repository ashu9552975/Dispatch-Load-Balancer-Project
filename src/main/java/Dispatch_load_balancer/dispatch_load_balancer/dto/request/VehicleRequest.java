package Dispatch_load_balancer.dispatch_load_balancer.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class VehicleRequest {

    @NotBlank
    private String vehicleId;

    @Positive
    private double capacity;

    @NotNull
    private Double currentLatitude;

    @NotNull
    private Double currentLongitude;

    @NotBlank
    private String currentAddress;

}

