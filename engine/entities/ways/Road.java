package engine.entities.ways;
import engine.entities.city.*;

public class Road {
    private int id;
    private EnumRoad type;
    private City departure;
    private City arrival;
    private int speedLimit;
    private int nWays;

    public EnumRoad getType() {
        return type;
    }

    public void setType(String type) {
        this.type = EnumRoad.valueOf(type);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void debug() {
        System.out.println("Road " + this.id);
        System.out.println("Type " + this.type);
        System.out.println("Departure " + this.departure.getId());
        System.out.println("Arrival " + this.arrival.getId());
    }
}