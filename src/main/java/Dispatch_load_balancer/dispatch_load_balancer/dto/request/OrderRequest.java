package Dispatch_load_balancer.dispatch_load_balancer.dto.request;

import Dispatch_load_balancer.dispatch_load_balancer.domain.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderRequest {

    @NotBlank
    private String orderId;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotBlank
    private String address;

    @Positive
    private double packageWeight;

    @NotNull
    private Priority priority;

}

