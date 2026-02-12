package Dispatch_load_balancer.dispatch_load_balancer.mapper;

import Dispatch_load_balancer.dispatch_load_balancer.domain.model.GeoLocation;
import Dispatch_load_balancer.dispatch_load_balancer.domain.model.Vehicle;
import Dispatch_load_balancer.dispatch_load_balancer.dto.request.VehicleRequest;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public Vehicle toEntity(VehicleRequest dto) {
        return new Vehicle(
                dto.getVehicleId(),
                dto.getCapacity(),
                new GeoLocation(dto.getCurrentLatitude(), dto.getCurrentLongitude()),
                dto.getCurrentAddress()
        );
    }
}
