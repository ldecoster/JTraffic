package engine.entities.vehicle;
import engine.entities.city.*;
import engine.entities.utils.*;
import engine.entities.ways.*;

public class Vehicle {
    private City departure;
    private City arrival;
    private Coords currentPos;
    private int currentWay = 0;
    private Road currentRoad;

    public City getDeparture() {
        return departure;
    }

    public void setDeparture(City departure) {
        this.departure = departure;
    }

    public City getArrival() {
        return arrival;
    }

    public void setArrival(City arrival) {
        this.arrival = arrival;
    }

    public Coords getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Coords currentPos) {
        this.currentPos = currentPos;
    }

    public int getCurrentWay() {
        return currentWay;
    }

    public void setCurrentWay(int currentWay) {
        this.currentWay = currentWay;
    }

    public Road getCurrentRoad() {
        return currentRoad;
    }

    public void setCurrentRoad(Road currentRoad) {
        this.currentRoad = currentRoad;
    }
}