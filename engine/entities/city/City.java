package engine.entities.city;
import engine.entities.utils.*;

public class City {
    private int id = 99;
    private Coords coordinates;
    private int vehiclesPerMinute = 99;

    public City(int id, Coords coordinates, int vehiclesPerMinute) {
        this.id = id;
        this.coordinates = coordinates;
        this.vehiclesPerMinute = vehiclesPerMinute;
    }

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coords getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coords coordinates) {
        this.coordinates = coordinates;
    }

    public int getVehiclesPerMinute() {
        return vehiclesPerMinute;
    }

    public void setVehiclesPerMinute(int vehiclesPerMinute) {
        this.vehiclesPerMinute = vehiclesPerMinute;
    }

    public void debug() {
        System.out.println("City " + this.id);
        System.out.println("x = " + this.coordinates.getX());
        System.out.println("y = " + this.coordinates.getY());
        System.out.println("Vehicles per Minute " + this.vehiclesPerMinute);
    }
}