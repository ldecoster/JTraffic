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
    private boolean started = false;
    private boolean arrived = false;
    private float t = 0;

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

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isArrived() {
        return arrived;
    }

    public void setArrived(boolean arrived) {
        this.arrived = arrived;
    }

    public float getT() {
        return t;
    }

    public void setT(float t) {
        this.t = t;
    }
}