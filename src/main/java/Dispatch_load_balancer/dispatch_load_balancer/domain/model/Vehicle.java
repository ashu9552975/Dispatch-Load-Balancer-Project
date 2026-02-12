package Dispatch_load_balancer.dispatch_load_balancer.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Vehicle {

    private String vehicleId;
    private double capacity;
    private double currentLoad = 0;
    private GeoLocation currentLocation;
    private String currentAddress;
    private List<Order> assignedOrders = new ArrayList<>();
    private double totalDistance = 0;

    public Vehicle(String vehicleId, double capacity, GeoLocation currentLocation, String currentAddress) {
        this.vehicleId = vehicleId;
        this.capacity = capacity;
        this.currentLocation = currentLocation;
        this.currentAddress = currentAddress;
    }

    public boolean canAccommodate(double weight) {
        return currentLoad + weight <= capacity;
    }

    public void assignOrder(Order order, double distance) {
        assignedOrders.add(order);
        currentLoad += order.getPackageWeight();
        totalDistance += distance;
        order.setAssigned(true);
    }

    public List<Order> getAssignedOrders() {
        return assignedOrders;
    }
}
