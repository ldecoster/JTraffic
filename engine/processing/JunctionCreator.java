package engine.processing;

import java.util.Vector;

import engine.entities.ways.*;
import engine.entities.utils.Coords;

public class JunctionCreator {

    public void createJunctions(Vector<Road> roads, Vector<Junction> junctions) {

        Vector<Float> v1, v2;

        for (int i = 0; i < roads.size(); i++) {
            if (roads.get(i).getType() != EnumRoad.HIGHWAY) {

                v1 = roads.get(i).computeEquation();

                for (int j = i; j < roads.size(); j++) {
                    if (i != j) {

                        v2 = roads.get(j).computeEquation();
                        float x = (v2.get(1) - v1.get(1)) / (v1.get(0) - v2.get(0));
                        float y = v1.get(0) * x + v1.get(1);

                        if (x > 0 && x < 800 && y > 0 && y < 600) {
                            System.out.println("(" + x + "," + y + ")");

                            Junction newJunction = new Junction();
                            Coords coords = new Coords((int) x, (int) y);
                            newJunction.setCoordinates(coords);

                            junctions.add(newJunction);
                        }


                    }
                }
            }
        }

    }
}
