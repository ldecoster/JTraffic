package engine.processing;

import engine.entities.city.City;
import engine.entities.vehicle.Vehicle;
import engine.entities.ways.Road;
import engine.processing.utils.ReachableCities;
import engine.processing.utils.WayFinder;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class VehiclesCreator extends Thread{
    private Vector<Vehicle> vehicles;
    private Vector<City> reachable;
    private Vector<Road> roads;
    private City city;
    private AtomicBoolean running = new AtomicBoolean(false);

    public VehiclesCreator(Vector<Vehicle> v, Vector<Road> r, City c) {
        this.vehicles = v;
        this.city = c;
        this.roads = r;

        this.reachable = ReachableCities.getCities(this.roads, this.city);
    }

    public AtomicBoolean getRunning() {
        return running;
    }

    public void setRunning(AtomicBoolean running) {
        this.running = running;
    }

    public void run() {
        float delay = 60 / (float) this.city.getVehiclesPerMinute();
        running.set(true);

        while (running.get()) {
            Vehicle newVehicle = new Vehicle();

            newVehicle.setDeparture(this.city);
            newVehicle.setArrival(this.reachable.get(ReachableCities.getRandomNumberInRange(0, this.reachable.size() - 1)));
            newVehicle.setCurrentPos(this.city.getCoordinates());
            newVehicle.setCurrentRoad(WayFinder.findRoad(this.roads, this.city, newVehicle.getArrival()));

            this.vehicles.add(newVehicle);

            try {
                Thread.sleep((int) (delay * 1000));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
