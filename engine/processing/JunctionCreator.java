package engine.processing;

import java.util.Vector;

import engine.entities.ways.*;

public class JunctionCreator {

    public void createJunctions(Vector<Road> roads, Vector<Junction> junctions) {

        Vector<Float> v1, v2;

        for (int i = 0; i < roads.size(); i++) {
            if (roads.get(i).getType() != EnumRoad.HIGHWAY) {

                v1 = roads.get(i).computeEquation();

                for (int j = 0; j < roads.size(); j++) {
                    if (i != j) {

                        v2 = roads.get(j).computeEquation();
                        float x = (v2.get(1) - v1.get(1)) / (v2.get(0) - v1.get(0));
                        float y = v1.get(0) * ((v2.get(1) - v1.get(1)) / (v2.get(0) - v1.get(0))) + v1.get(1);

                        System.out.println("(" + x + "," + y + ")");

                    }
                }
            }
        }

    }
}
