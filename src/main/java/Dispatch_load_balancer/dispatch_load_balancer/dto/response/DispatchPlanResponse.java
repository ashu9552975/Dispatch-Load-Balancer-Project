package Dispatch_load_balancer.dispatch_load_balancer.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class DispatchPlanResponse {

    private List<VehicleDispatchResponse> dispatchPlan;
    private List<AssignedOrderResponse> unassignedOrders;
}
