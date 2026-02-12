package Dispatch_load_balancer.dispatch_load_balancer.mapper;

import Dispatch_load_balancer.dispatch_load_balancer.domain.model.GeoLocation;
import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Order;
import Dispatch_load_balancer.dispatch_load_balancer.dto.request.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequest dto) {
        return new Order(
                dto.getOrderId(),
                new GeoLocation(dto.getLatitude(), dto.getLongitude()),
                dto.getAddress(),
                dto.getPackageWeight(),
                dto.getPriority(),
                false
        );
    }
}
