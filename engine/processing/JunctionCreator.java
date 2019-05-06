package engine.processing;

import java.util.Vector;

import engine.entities.ways.*;
import engine.entities.utils.Coords;

public class JunctionCreator {

    public void createJunctions(Vector<Road> roads, Vector<Junction> junctions) {

        Vector<Float> v1, v2;
        float xmin, xmax, ymin, ymax;

        for (int i = 0; i < roads.size(); i++) {
            if (roads.get(i).getType() != EnumRoad.HIGHWAY) {

                v1 = roads.get(i).computeEquation();

                for (int j = i; j < roads.size(); j++) {
                    if (i != j && roads.get(j).getType() != EnumRoad.HIGHWAY) {

                        v2 = roads.get(j).computeEquation();
                        float x = (v2.get(1) - v1.get(1)) / (v1.get(0) - v2.get(0));
                        float y = v1.get(0) * x + v1.get(1);

                        if (x > 0 && x < 800 && y > 0 && y < 600) {

                            // Exclude the extremities
                            xmin = Math.min(Math.min(roads.get(i).getDeparture().getCoordinates().getX(), roads.get(j).getDeparture().getCoordinates().getX()), Math.min(roads.get(i).getArrival().getCoordinates().getX(), roads.get(j).getArrival().getCoordinates().getX()));
                            xmax = Math.max(Math.max(roads.get(i).getDeparture().getCoordinates().getX(), roads.get(j).getDeparture().getCoordinates().getX()), Math.max(roads.get(i).getArrival().getCoordinates().getX(), roads.get(j).getArrival().getCoordinates().getX()));
                            ymin = Math.min(Math.min(roads.get(i).getDeparture().getCoordinates().getY(), roads.get(j).getDeparture().getCoordinates().getY()), Math.min(roads.get(i).getArrival().getCoordinates().getX(), roads.get(j).getArrival().getCoordinates().getX()));
                            ymax = Math.max(Math.max(roads.get(i).getDeparture().getCoordinates().getY(), roads.get(j).getDeparture().getCoordinates().getY()), Math.max(roads.get(i).getArrival().getCoordinates().getX(), roads.get(j).getArrival().getCoordinates().getX()));

                            if(x > xmin && x < xmax && y > ymin && y < ymax) {
                                // System.out.println("(" + x + "," + y + ")");

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
        // Remove occurencies
        junctions = new Vector(new java.util.HashSet(junctions));

    }
}
