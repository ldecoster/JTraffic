package engine.processing;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import engine.processing.utils.ReachableCities;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;

import java.util.Vector;
import java.util.Map;

import engine.entities.city.*;
import engine.entities.ways.*;
import engine.entities.utils.Coords;

public class InitParse {

    public City getCityById(Vector<City> cities, int id)  {
        for (City c : cities) {
            if (c.getId() == id) {
                return c;
            }
        }

        return null;
    }

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

                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    City newCity = new City();

                    Coords coords = new Coords(Integer.parseInt(child.getAttributes().getNamedItem("x").getNodeValue()), Integer.parseInt(child.getAttributes().getNamedItem("y").getNodeValue()));
                    newCity.setCoordinates(coords);

                    NodeList cityInfo= child.getChildNodes();

                    for (int j = 0; j < cityInfo.getLength(); j++) {
                       Node item = cityInfo.item(j);

                       switch(item.getNodeName()) {
                           case "id":
                               newCity.setId(Integer.parseInt(item.getTextContent()));
                               break;
                           case "vehiclesPerMinute":
                               newCity.setVehiclesPerMinute(Integer.parseInt(item.getTextContent()));
                               break;
                       }
                    }
                    cities.add(newCity);
                }

            }

            int roadId = 0;

            NodeList inRoads = doc.getElementsByTagName("roads").item(0).getChildNodes();

            RoadPropreties rp = new RoadPropreties();

            for (int i = 0; i < inRoads.getLength(); i++) {
                child = inRoads.item(i);

                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    Road newRoad = new Road();

                    newRoad.setId(roadId);
                    roadId++;

                    NodeList roadInfo= child.getChildNodes();

                    for (int j = 0; j < roadInfo.getLength(); j++) {
                        Node item = roadInfo.item(j);

                        switch(item.getNodeName()) {
                            case "type":
                                newRoad.setType(item.getTextContent());
                                break;
                            case "departure":
                                newRoad.setDeparture(getCityById(cities, Integer.parseInt(item.getTextContent())));
                                break;
                            case "arrival":
                                newRoad.setArrival(getCityById(cities, Integer.parseInt(item.getTextContent())));
                                break;
                        }
                    }
                    rp.applyPropreties(newRoad);
                    roads.add(newRoad);
                }

            }


            // Get reachables cities from this city
            for (int i = 0; i < cities.size(); i++) {
                cities.get(i).setReachable(ReachableCities.getCities(roads, cities.get(i)));
            }

            return true;
        }
        return false;
    }
}