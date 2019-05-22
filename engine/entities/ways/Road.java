package engine.entities.ways;

import engine.entities.city.*;
import engine.entities.utils.Coords;

import java.util.Vector;

public class Road {
    private Vector<Float> equation = new Vector<>();
    private int id;
    private EnumRoad type;
    private City departure;
    private City arrival;
    private int speedLimit;
    private int nWays;
    private Vector<Integer> vectorDirector = new Vector<>();

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

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getNWays() {
        return nWays;
    }

    public void setNWays(int nWays) {
        this.nWays = nWays;
    }

    public void setEquation(Vector<Float> equation) {
        this.equation = equation;
    }

    public Vector<Float> getEquation() {
        return equation;
    }

    public Coords getNextPoint(float t){
        if (vectorDirector.isEmpty()){
            vectorDirector.add(this.arrival.getCoordinates().getX() - this.departure.getCoordinates().getX());
            vectorDirector.add(this.arrival.getCoordinates().getY() - this.departure.getCoordinates().getY());
        }
        Coords tmp = new Coords(0,0);
        tmp.setX((int) (this.departure.getCoordinates().getX() + vectorDirector.get(0)*t));
        tmp.setY((int) (this.departure.getCoordinates().getY() + vectorDirector.get(1)*t));
        return tmp;
    }

    public Vector<Float> computeEquation() {

        float a = ((float) arrival.getCoordinates().getY() - (float) departure.getCoordinates().getY())/((float) arrival.getCoordinates().getX() - (float) departure.getCoordinates().getX());
        float b = arrival.getCoordinates().getY() - a * arrival.getCoordinates().getX();

        this.equation.add(a);
        this.equation.add(b);

        /*System.out.println(a + " * x + " + b);
        System.out.println("(" + departure.getCoordinates().getX() + "," + departure.getCoordinates().getY() + ") et (" + arrival.getCoordinates().getX() + "," + arrival.getCoordinates().getY() + ")");
        System.out.println(arrival.getCoordinates().getY() - departure.getCoordinates().getY());
        System.out.println(arrival.getCoordinates().getX() - departure.getCoordinates().getX());*/

        return this.equation;
    }


    public void debug() {
        System.out.println("\n Road " + this.id);
        System.out.println("Type " + this.type);
        System.out.println("Departure City " + this.departure.getId());
        System.out.println("Arrival City " + this.arrival.getId());
        System.out.println("SpeedLimit " + this.speedLimit);
        System.out.println("Number of ways " + this.nWays);
    }
}