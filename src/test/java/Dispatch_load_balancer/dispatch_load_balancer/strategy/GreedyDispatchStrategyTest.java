package Dispatch_load_balancer.dispatch_load_balancer.strategy;

import Dispatch_load_balancer.dispatch_load_balancer.domain.enums.Priority;
import Dispatch_load_balancer.dispatch_load_balancer.domain.model.GeoLocation;
import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Order;
import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Vehicle;
import Dispatch_load_balancer.dispatch_load_balancer.strategy.impl.GreedyDispatchStrategy;
import Dispatch_load_balancer.dispatch_load_balancer.util.HaversineDistanceUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GreedyDispatchStrategyTest {

    private final HaversineDistanceUtil distanceUtil = new HaversineDistanceUtil();
    private final GreedyDispatchStrategy strategy = new GreedyDispatchStrategy(distanceUtil);

    @Test
    void highPriorityOrdersAreAssignedFirstWithinCapacity() {
        Vehicle v1 = new Vehicle("VEH1", 100, new GeoLocation(28.7041, 77.1025), "Karol Bagh, Delhi");
        Vehicle v2 = new Vehicle("VEH2", 100, new GeoLocation(28.5355, 77.3910), "Noida, UP");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(v1);
        vehicles.add(v2);

        Order highPriority = new Order("ORD_HIGH",
                new GeoLocation(28.7041, 77.1025),
                "Karol Bagh, Delhi",
                10,
                Priority.HIGH,
                false);

        Order lowPriority = new Order("ORD_LOW",
                new GeoLocation(28.5355, 77.3910),
                "Noida, UP",
                10,
                Priority.LOW,
                false);

        List<Order> orders = new ArrayList<>();
        orders.add(lowPriority);
        orders.add(highPriority);

        strategy.dispatch(orders, vehicles);
        Assertions.assertTrue(highPriority.isAssigned());
        Assertions.assertTrue(lowPriority.isAssigned());
        Assertions.assertEquals(20.0, v1.getCurrentLoad() + v2.getCurrentLoad(), 1e-6);
    }
}
