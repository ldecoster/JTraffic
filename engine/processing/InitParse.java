package engine.processing;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

import engine.entities.city.*;
import engine.entities.ways.*;
import engine.entities.utils.Coords;

public class InitParse {

    public Document parseInitFile(String path) {
        try {
            File fXmlFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            return doc;
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean createObjects(Document doc, Vector<City> cities, Vector<Road> roads, Map<String, String> meta) {
        if(doc != null) {
            /*
                Get metadata
            */

            NodeList inMeta = doc.getElementsByTagName("metadata").item(0).getChildNodes();
            Node child;

            for (int i = 0; i < inMeta.getLength(); i++) {
                child = inMeta.item(i);

                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    meta.put(child.getNodeName(), child.getTextContent());
                }
            }

            /*
                Get the map specs
            */

            NodeList inCities = doc.getElementsByTagName("cities").item(0).getChildNodes();

            for (int i = 0; i < inCities.getLength(); i++) {
                child = inCities.item(i);
                City newCity = new City();

                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    Coords coords = new Coords(Integer.parseInt(child.getAttributes().getNamedItem("x").getNodeValue()), Integer.parseInt(child.getAttributes().getNamedItem("y").getNodeValue()));
                    newCity.setCoords(coords);

                    NodeList cityInfo= child.getChildNodes();

                   for (int j = 0; j < cityInfo.getLength(); j++) {
                       Node item = cityInfo.item(j);

                       if (item.getNodeName() == "id") {
                            newCity.setId(Integer.parseInt(item.getTextContent()));
                       }
                       else if (item.getNodeName() == "vehiclesPerMinute") {
                            newCity.setVehiclesPerMinute(Integer.parseInt(item.getTextContent()));
                        }
                    }
                }

                cities.add(newCity);
            }

            /*NodeList roads = doc.getElementsByTagName("roads").item(0).getChildNodes();

            for (int i = 0; i < meta.getLength(); i++) {
                Node road = roads.item(i);

                if (road.getNodeType() == Node.ELEMENT_NODE) {

                }
            }*/

            return true;
        }
        return false;
    }
}