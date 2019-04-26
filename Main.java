import engine.processing.InitParse;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

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
        Map<String, String> config = new HashMap<>();

        parser.createObjects(doc);
    }
}