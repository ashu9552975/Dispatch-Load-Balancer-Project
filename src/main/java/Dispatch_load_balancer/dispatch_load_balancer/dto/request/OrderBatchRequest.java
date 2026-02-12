package Dispatch_load_balancer.dispatch_load_balancer.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderBatchRequest {

    @Valid
    @NotNull
    @NotEmpty
    private List<OrderRequest> orders;

}


