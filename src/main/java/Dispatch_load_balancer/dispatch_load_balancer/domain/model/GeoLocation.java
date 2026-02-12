package Dispatch_load_balancer.dispatch_load_balancer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoLocation {

    private double latitude;
    private double longitude;
}
