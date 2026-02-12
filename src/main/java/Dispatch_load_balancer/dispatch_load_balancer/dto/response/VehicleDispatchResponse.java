package Dispatch_load_balancer.dispatch_load_balancer.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class VehicleDispatchResponse {

    private String vehicleId;
    private double capacity;
    private double totalLoad;
    private String currentAddress;
    private double currentLatitude;
    private double currentLongitude;
    private String totalDistance;
    private List<AssignedOrderResponse> assignedOrders;
}

