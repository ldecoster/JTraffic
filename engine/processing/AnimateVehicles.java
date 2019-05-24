package engine.processing;

import engine.entities.utils.Coords;
import engine.entities.vehicle.Vehicle;
import engine.entities.ways.Junction;
import engine.entities.ways.Road;

import java.util.Vector;

public class AnimateVehicles {

    private Vector<Vehicle> vehicles;
    Vector<Junction> junctions;

    public AnimateVehicles(Vector<Vehicle> v, Vector<Junction> j) {
        this.vehicles = v;
        this.junctions = j;
    }

    public void moveAllVehicles() {
        Coords tmpCoords;
        Road tmpRoad;
        float tmpT;
        float speed;
        float nextT;
        float limit = 1.0f;

        // Foreach vehicle
        for (Vehicle v : vehicles) {

            // If vehicle is not arrived to destination (t < 1)
            if (!v.isArrived()) {
                tmpRoad = v.getCurrentRoad();
                tmpT = v.getT();
                speed = tmpRoad.getSpeedLimit();
                limit = 1.0f;

                // Test if we are near an intersection
                for (Junction j : junctions) {
                    if (Math.sqrt(Math.pow(v.getCurrentPos().getX() - j.getCoordinates().getX(), 2) + Math.pow(v.getCurrentPos().getY() - j.getCoordinates().getY(), 2)) < 20) {
                        limit = 0.1f;
                    }
                }

                // Compute next point
                nextT = tmpT + (1 / (200-(speed*limit)));

                tmpCoords = tmpRoad.getNextPoint(nextT);
                v.setT(nextT);
                v.setCurrentPos(tmpCoords);

                // If it's first time we move the vehicle
                if (!v.isStarted()) {
                    v.setStarted(true);
                }

                // If the vehicle is arrived, stop it
                if (nextT >= 0.99) {
                    v.setArrived(true);
                }
            }

        }
    }
}
