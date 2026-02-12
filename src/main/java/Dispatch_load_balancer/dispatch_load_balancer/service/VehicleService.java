package Dispatch_load_balancer.dispatch_load_balancer.service;

import Dispatch_load_balancer.dispatch_load_balancer.dto.request.VehicleBatchRequest;
import Dispatch_load_balancer.dispatch_load_balancer.mapper.VehicleMapper;
import Dispatch_load_balancer.dispatch_load_balancer.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository repo;
    private final VehicleMapper mapper;

    public void save(VehicleBatchRequest request) {
        repo.saveAll(request.getVehicles()
                .stream()
                .map(mapper::toEntity)
                .toList());
    }
}
