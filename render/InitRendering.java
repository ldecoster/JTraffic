package render;

import engine.entities.city.City;
import engine.entities.ways.Junction;
import engine.entities.ways.Road;
import engine.entities.vehicle.Vehicle;
import engine.processing.InitParse;

import engine.processing.JunctionCreator;
import engine.processing.VehiclesCreator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.w3c.dom.Document;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class InitRendering extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        InitParse parser = new InitParse();
        Document doc = parser.parseInitFile("maps/map1.xml");

        Vector<City> cities = new Vector<City>();
        Vector<Road> roads = new Vector<Road>();
        Map<String, String> meta = new HashMap<>();
        Vector<Junction> junctions = new Vector<Junction>();
        Vector<Vehicle> vehicles = new Vector<Vehicle>();
        Vector<VehiclesCreator> creators = new Vector<VehiclesCreator>();

        parser.createObjects(doc, cities, roads, meta);

        System.out.println(Collections.singletonList(meta));

        JunctionCreator jc = new JunctionCreator();

        jc.createJunctions(roads, junctions);

        /*for(City c : cities) {
            c.debug();
        }

        for(Road r : roads) {
            r.debug();
        }*/

        makeScene customScene = new makeScene(cities, roads, junctions);
        Scene scene = customScene.getScene();

        primaryStage.setScene(scene);
        primaryStage.setTitle("JTraffic");
        primaryStage.show();

        for (City c : cities) {
            creators.add(new VehiclesCreator(vehicles, roads, c));
        }

        for (VehiclesCreator vc : creators) {
            vc.start();
        }
    }

}
