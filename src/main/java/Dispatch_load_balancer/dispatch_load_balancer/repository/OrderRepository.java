package Dispatch_load_balancer.dispatch_load_balancer.repository;

import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {


    private final Map<String, Order> store = new ConcurrentHashMap<>();


    public void saveAll(List<Order> orders) {
        orders.forEach(o -> store.put(o.getOrderId(), o));
    }


    public List<Order> findAll() {
        return new ArrayList<>(store.values());
    }
}
