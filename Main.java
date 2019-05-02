import engine.processing.InitParse;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.Collections;

import engine.entities.city.*;
import engine.entities.utils.*;
import engine.entities.ways.*;
import engine.entities.vehicle.*;


public class Main {
    public static void main(String args[]) {
        InitParse parser = new InitParse();
        Document doc = parser.parseInitFile("./InitStructure.xml");

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
    }
}