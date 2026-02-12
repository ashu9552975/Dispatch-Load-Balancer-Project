package Dispatch_load_balancer.dispatch_load_balancer.repository;

import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class VehicleRepository {


    private final Map<String, Vehicle> store = new ConcurrentHashMap<>();


    public void saveAll(List<Vehicle> vehicles) {
        vehicles.forEach(v -> store.put(v.getVehicleId(), v));
    }


    public List<Vehicle> findAll() {
        return new ArrayList<>(store.values());
    }
}
