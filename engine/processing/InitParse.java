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

    public boolean createObjects(Document doc/*, Vector<City> cities, Vector<Road> roads, Map<String, String> config*/) {
        if(doc != null) {
            /*
                On récupère la configuration de notre init
            */

            NodeList meta = doc.getElementsByTagName("metadata").item(0).getChildNodes();

            for (int i = 0; i < meta.getLength(); i++) {
                Node childNode = meta.item(i);

                System.out.println(childNode.getNodeName());
            }

            return true;
        }
        return false;
    }
}