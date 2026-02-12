package Dispatch_load_balancer.dispatch_load_balancer.util;

import Dispatch_load_balancer.dispatch_load_balancer.domain.model.GeoLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HaversineDistanceUtilTest {

    private final HaversineDistanceUtil distanceUtil = new HaversineDistanceUtil();

    @Test
    void calculate_returnsZeroForSameLocation() {
        GeoLocation a = new GeoLocation(28.6139, 77.2090);
        GeoLocation b = new GeoLocation(28.6139, 77.2090);

        double distance = distanceUtil.calculate(a, b);

        Assertions.assertEquals(0.0, distance, 1e-6);
    }

    @Test
    void calculate_returnsPositiveDistanceForDifferentLocations() {
        GeoLocation delhi = new GeoLocation(28.6139, 77.2090);
        GeoLocation noida = new GeoLocation(28.5355, 77.3910);

        double distance = distanceUtil.calculate(delhi, noida);

        Assertions.assertTrue(distance > 0);
    }
}

