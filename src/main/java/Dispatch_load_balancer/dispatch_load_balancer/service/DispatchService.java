package Dispatch_load_balancer.dispatch_load_balancer.service;

import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Order;
import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Vehicle;
import Dispatch_load_balancer.dispatch_load_balancer.dto.response.AssignedOrderResponse;
import Dispatch_load_balancer.dispatch_load_balancer.dto.response.DispatchPlanResponse;
import Dispatch_load_balancer.dispatch_load_balancer.dto.response.VehicleDispatchResponse;
import Dispatch_load_balancer.dispatch_load_balancer.exception.DispatchException;
import Dispatch_load_balancer.dispatch_load_balancer.repository.OrderRepository;
import Dispatch_load_balancer.dispatch_load_balancer.repository.VehicleRepository;
import Dispatch_load_balancer.dispatch_load_balancer.strategy.DispatchStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DispatchService {

    private final OrderRepository orderRepo;
    private final VehicleRepository vehicleRepo;
    private final DispatchStrategy strategy;

    public DispatchPlanResponse generatePlan() {
        List<Order> orders = orderRepo.findAll();
        List<Vehicle> vehicles = vehicleRepo.findAll();

        if (orders.isEmpty()) {
            throw new DispatchException("No delivery orders available to generate dispatch plan.");
        }

        if (vehicles.isEmpty()) {
            throw new DispatchException("No vehicles available to generate dispatch plan.");
        }

        strategy.dispatch(orders, vehicles);

        List<VehicleDispatchResponse> vehicleResponses = vehicles.stream()
                .map(this::mapVehicle)
                .toList();

        List<AssignedOrderResponse> unassignedOrders = orders.stream()
                .filter(o -> !o.isAssigned())
                .map(this::mapOrder)
                .toList();

        DispatchPlanResponse response = new DispatchPlanResponse();
        response.setDispatchPlan(vehicleResponses);
        response.setUnassignedOrders(unassignedOrders);
        return response;
    }

    private VehicleDispatchResponse mapVehicle(Vehicle v) {
        List<AssignedOrderResponse> orders = v.getAssignedOrders()
                .stream()
                .map(this::mapOrder)
                .toList();

        VehicleDispatchResponse dto = new VehicleDispatchResponse();
        dto.setVehicleId(v.getVehicleId());
        dto.setCapacity(v.getCapacity());
        dto.setCurrentAddress(v.getCurrentAddress());
        if (v.getCurrentLocation() != null) {
            dto.setCurrentLatitude(v.getCurrentLocation().getLatitude());
            dto.setCurrentLongitude(v.getCurrentLocation().getLongitude());
        }
        dto.setTotalLoad(v.getCurrentLoad());
        dto.setTotalDistance(Math.round(v.getTotalDistance()) + " km");
        dto.setAssignedOrders(orders);
        return dto;
    }

    private AssignedOrderResponse mapOrder(Order o) {
        AssignedOrderResponse dto = new AssignedOrderResponse();
        dto.setOrderId(o.getOrderId());
        if (o.getLocation() != null) {
            dto.setLatitude(o.getLocation().getLatitude());
            dto.setLongitude(o.getLocation().getLongitude());
        }
        dto.setAddress(o.getAddress());
        dto.setPackageWeight(o.getPackageWeight());
        dto.setPriority(o.getPriority());
        return dto;
    }
}
