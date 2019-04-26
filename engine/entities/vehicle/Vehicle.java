package engine.entities.vehicle;
import engine.entities.city.*;
import engine.entities.utils.*;
import engine.entities.ways.*;

public class Vehicle {
    private City departure;
    private City arrival;
    private Coords currentPos;
    private int currentWay;
    private Road currentRoad;
}