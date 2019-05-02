package engine.entities.ways;

import engine.entities.utils.*;

public class Junction {
    private Coords coordinates;
    private EnumJunction type;
    private int waitingTime;

    public Coords getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coords coordinates) {
        this.coordinates = coordinates;
    }

    public EnumJunction getType() {
        return type;
    }

    public void setType(EnumJunction type) {
        this.type = type;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}

