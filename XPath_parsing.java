package ParsingAndCreate;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XPath_parsing {
    private void is_EmptyNode(NodeList list) {
        if (list.getLength() <= 0) {
            throw new IllegalArgumentException("You document is empty check please awayToDocument");
        }
    }

    private boolean hasChildren(NodeList list) {
        is_EmptyNode(list);
        int counter = 0;
        for (int i = 0; i < list.getLength(); i++) {
            NodeList element = list.item(i).getChildNodes();
            for (int j = 0; j < element.getLength(); j++) {
                if (element.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    counter++;
                    break;
                }
            }
        }
        if (counter == list.getLength()) {
            return true;
        }
        return false;
    }

    private void retValue(NodeList list) {
        is_EmptyNode(list);
        if (hasChildren(list)) {
            for (int i = 0; i < list.getLength(); i++) {
                NodeList element = list.item(i).getChildNodes();
                System.out.println("Element " + i + " has:");
                for (int j = 0; j < element.getLength(); j++) {
                    if (element.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(element.item(j).getNodeName());
                    }
                }
            }
        }
    }

    public void bublicXpath(String awayToFile) {
        try {
            File inputFile = new File(awayToFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            String expression = "company/department/employee";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
                    doc, XPathConstants.NODESET);
            is_EmptyNode(nodeList);
            System.out.println(hasChildren(nodeList));
            retValue(nodeList);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
