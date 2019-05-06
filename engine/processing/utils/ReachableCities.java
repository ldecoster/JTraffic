package engine.processing.utils;

import engine.entities.city.City;
import engine.entities.ways.Road;

import java.util.Vector;

public class ReachableCities {
    public static Vector<City> getCities(Vector<Road> r, City c) {
        Vector<City> reachable = new Vector<City>();

        for (Road elt : r) {
            if (elt.getDeparture() == c) {
                reachable.add(elt.getArrival());
            }
        }

        return reachable;
    }

}
