package Dispatch_load_balancer.dispatch_load_balancer.strategy;

import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Order;
import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Vehicle;

import java.util.List;

public interface DispatchStrategy {

    List<Vehicle> dispatch(List<Order> orders, List<Vehicle> vehicles);
}
