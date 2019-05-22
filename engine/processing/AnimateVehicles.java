package engine.processing;

import engine.entities.utils.Coords;
import engine.entities.vehicle.Vehicle;
import engine.entities.ways.Road;

import java.util.Vector;

public class AnimateVehicles {

    private Vector<Vehicle> vehicles;

    public void moveAllVehicles() {
        Coords tmpCoords;
        Road tmpRoad;
        int tmpT;
        int speed;
        int nextT;

        for (Vehicle v : vehicles) {
            tmpRoad = v.getCurrentRoad();
            tmpT = v.getT();
            speed = tmpRoad.getSpeedLimit();

            nextT = tmpT + (1 / (200-speed));

            tmpCoords = tmpRoad.getNextPoint(nextT);
            v.setT(nextT);
            v.setCurrentPos(tmpCoords);
        }
    }
}
