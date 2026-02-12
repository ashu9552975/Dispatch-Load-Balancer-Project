package Dispatch_load_balancer.dispatch_load_balancer.util;

import Dispatch_load_balancer.dispatch_load_balancer.domain.model.GeoLocation;
import org.springframework.stereotype.Component;

@Component
public class HaversineDistanceUtil {

    private static final int EARTH_RADIUS_KM = 6371;

    public double calculate(GeoLocation a, GeoLocation b) {
        double latDiff = Math.toRadians(b.getLatitude() - a.getLatitude());
        double lonDiff = Math.toRadians(b.getLongitude() - a.getLongitude());

        double hav = Math.sin(latDiff / 2) * Math.sin(latDiff / 2)
                + Math.cos(Math.toRadians(a.getLatitude()))
                * Math.cos(Math.toRadians(b.getLatitude()))
                * Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);

        double c = 2 * Math.atan2(Math.sqrt(hav), Math.sqrt(1 - hav));
        return EARTH_RADIUS_KM * c;
    }
}
