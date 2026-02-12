package Dispatch_load_balancer.dispatch_load_balancer.dto.response;

import Dispatch_load_balancer.dispatch_load_balancer.domain.enums.Priority;
import lombok.Data;

@Data
public class AssignedOrderResponse {

    private String orderId;
    private double latitude;
    private double longitude;
    private String address;
    private double packageWeight;
    private Priority priority;

}

