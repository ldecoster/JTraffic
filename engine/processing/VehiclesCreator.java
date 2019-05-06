package engine.processing;

import engine.entities.city.City;
import engine.entities.vehicle.Vehicle;

import java.util.Vector;

public class VehiclesCreator extends Thread{
    private Vector<Vehicle> vehicles;
    private City city;

    public VehiclesCreator(Vector<Vehicle> v, City c) {
        this.vehicles = v;
        this.city = c;
    }

    public void run() {

    }
}
