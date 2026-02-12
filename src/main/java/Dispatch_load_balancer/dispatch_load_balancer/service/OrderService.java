package Dispatch_load_balancer.dispatch_load_balancer.service;

import Dispatch_load_balancer.dispatch_load_balancer.dto.request.OrderBatchRequest;
import Dispatch_load_balancer.dispatch_load_balancer.mapper.OrderMapper;
import Dispatch_load_balancer.dispatch_load_balancer.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repo;
    private final OrderMapper mapper;

    public void save(OrderBatchRequest request) {
        repo.saveAll(request.getOrders()
                .stream()
                .map(mapper::toEntity)
                .toList());
    }
}
