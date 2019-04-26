import engine.processing.InitParse;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Main {
    public static void main(String args[]) {
        InitParse parser = new InitParse();

        Document doc = parser.parseInitFile("./InitStructure.xml");
    }
}