package Dispatch_load_balancer.dispatch_load_balancer.domain.model;

import Dispatch_load_balancer.dispatch_load_balancer.domain.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;
    private GeoLocation location;
    private String address;
    private double packageWeight;
    private Priority priority;
    private boolean assigned;
}
