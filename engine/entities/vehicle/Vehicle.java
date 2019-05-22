package engine.entities.vehicle;
import engine.entities.city.*;
import engine.entities.utils.*;
import engine.entities.ways.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class Vehicle {
    private City departure;
    private City arrival;
    private Coords currentPos;
    private int currentWay = 0;
    private Road currentRoad;
    private boolean started = false;
    private boolean arrived = false;
    private float t = 0;

    private Circle drawing;

    public Vehicle() {
        Circle circle = new Circle(3, Color.web("yellow"));
        circle.setStrokeType(StrokeType.OUTSIDE);
        circle.setStroke(Color.web("white", 1));
        circle.setStrokeWidth(2);
        this.setDrawing(circle);
    }

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

    public Circle getDrawing() {
        return drawing;
    }

    public void setDrawing(Circle drawing) {
        this.drawing = drawing;
    }
}