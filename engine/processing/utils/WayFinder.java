package engine.processing.utils;
import engine.entities.city.City;
import engine.entities.ways.Road;
import java.util.Vector;

public class WayFinder {
    public static Road WayFinder(Vector<Road> roads, City departure, City arrival) {
        Road vide = new Road();
        for (Road r : roads) {
            if (departure == r.getDeparture() && arrival == r.getArrival()) {
                return r;
            }
        }
        return vide;
    }
}
