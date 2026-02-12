package Dispatch_load_balancer.dispatch_load_balancer.strategy.impl;

import Dispatch_load_balancer.dispatch_load_balancer.domain.model.GeoLocation;
import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Order;
import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Vehicle;
import Dispatch_load_balancer.dispatch_load_balancer.strategy.DispatchStrategy;
import Dispatch_load_balancer.dispatch_load_balancer.util.HaversineDistanceUtil;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class GreedyDispatchStrategy implements DispatchStrategy {


    private final HaversineDistanceUtil distanceUtil;


    public GreedyDispatchStrategy(HaversineDistanceUtil distanceUtil) {
        this.distanceUtil = distanceUtil;
    }


    @Override
    public List<Vehicle> dispatch(List<Order> orders, List<Vehicle> vehicles) {
        // Ensuring that HIGH priority orders are processed first
        orders.sort(Comparator.comparing(Order::getPriority));

        for (Order order : orders) {
            Vehicle bestVehicle = null;
            double bestDistance = Double.MAX_VALUE;

            for (Vehicle vehicle : vehicles) {
                if (!vehicle.canAccommodate(order.getPackageWeight())) continue;
                GeoLocation from = vehicle.getAssignedOrders().isEmpty()
                        ? vehicle.getCurrentLocation()
                        : vehicle.getAssignedOrders()
                        .get(vehicle.getAssignedOrders().size() - 1)
                        .getLocation();
                double distance = distanceUtil.calculate(from, order.getLocation());
                if (distance < bestDistance) {
                    bestDistance = distance;
                    bestVehicle = vehicle;
                }
            }
            if (bestVehicle != null) {
                bestVehicle.assignOrder(order, bestDistance);
            }
        }
        return vehicles;
    }
}
