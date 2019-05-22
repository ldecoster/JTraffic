package engine.processing;

import engine.entities.utils.Coords;
import engine.entities.vehicle.Vehicle;
import engine.entities.ways.Road;

import java.util.Vector;

public class AnimateVehicles {

    private Vector<Vehicle> vehicles;

    public AnimateVehicles(Vector<Vehicle> v) {
        this.vehicles = v;
    }

    public void moveAllVehicles() {
        Coords tmpCoords;
        Road tmpRoad;
        float tmpT;
        float speed;
        float nextT;

        // Foreach vehicle
        for (Vehicle v : vehicles) {

            // If vehicle is not arrived to destination (t < 1)
            if (!v.isArrived()) {
                tmpRoad = v.getCurrentRoad();
                tmpT = v.getT();
                speed = tmpRoad.getSpeedLimit();

                // Compute next point
                nextT = tmpT + (1 / (150-speed));

                tmpCoords = tmpRoad.getNextPoint(nextT);
                v.setT(nextT);
                v.setCurrentPos(tmpCoords);

                // If it's first time we move the vehicle
                if (!v.isStarted()) {
                    v.setStarted(true);
                }

                // If the vehicle is arrived, stop it
                if (nextT >= 1) {
                    v.setArrived(true);
                }
            }

        }
    }
}
