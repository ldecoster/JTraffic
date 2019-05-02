import engine.processing.InitParse;

import javafx.application.Application;
import org.w3c.dom.Document;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.Collections;

import engine.entities.city.*;
import engine.entities.ways.*;
import render.InitRendering;


public class Main {
    public static void main(String args[]) {
        InitParse parser = new InitParse();
        Document doc = parser.parseInitFile("maps/InitStructure.xml");

        Vector<City> cities = new Vector<City>();
        Vector<Road> roads = new Vector<Road>();
        Map<String, String> meta = new HashMap<>();

        parser.createObjects(doc, cities, roads, meta);

        System.out.println(Collections.singletonList(meta));

        for(City c : cities) {
            c.debug();
        }

        for(Road r : roads) {
            r.debug();
        }

        Application.launch(InitRendering.class, args);
    }
}