import engine.processing.InitParse;

import org.w3c.dom.Document;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.Collections;

import engine.entities.city.*;
import engine.entities.ways.*;


public class Main {
    public static void main(String args[]) {
        InitParse parser = new InitParse();
        Document doc = parser.parseInitFile("maps/InitStructure.xml");

        Vector<City> cities = new Vector<City>();
        Vector<Road> roads = new Vector<Road>();
        Map<String, String> meta = new HashMap<>();

        parser.createObjects(doc, cities, roads, meta);

        System.out.println(Collections.singletonList(meta));
    }
}