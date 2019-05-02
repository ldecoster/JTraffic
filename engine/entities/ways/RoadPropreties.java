package engine.entities.ways;

import engine.entities.ways.EnumRoad;
import engine.entities.ways.Road;

import java.util.Map;
import java.util.HashMap;

public class RoadPropreties {

    private final Map<EnumRoad, Integer> nWays = new HashMap<>();
    private final Map<EnumRoad, Integer> speedLimits = new HashMap<>();

    public RoadPropreties() {
        nWays.put(EnumRoad.HIGHWAY, 3);
        nWays.put(EnumRoad.MAINROAD, 2);
        nWays.put(EnumRoad.COUNTRYROAD, 1);

        speedLimits.put(EnumRoad.HIGHWAY, 130);
        speedLimits.put(EnumRoad.MAINROAD, 80);
        speedLimits.put(EnumRoad.COUNTRYROAD, 50);
    }

    public void applyPropreties(Road r) {
        // Apply speed limits
        r.setSpeedLimit(speedLimits.get(r.getType()));

        // Apply number of ways
        r.setNWays(nWays.get(r.getType()));
    }
}
