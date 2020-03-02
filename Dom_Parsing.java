package ParsingAndCreate;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


public class Dom_Parsing {
    ArrayList<String> saveParentTagName = new ArrayList<>();
    ArrayList<Node> saveAttributeParentVC = new ArrayList<>();
    ArrayList<String> DateInInput = new ArrayList<>();
    ArrayList<String[]> saveChildNAC = new ArrayList<>();

    protected void showNAC() {
        if (saveChildNAC.size() <= 0) {
            throw new IllegalArgumentException("You saveChild is Empty size < 0 " + saveChildNAC.size());
        }
        for (String[] value : saveChildNAC) {
            for (int i = 0; i < value.length; i++) {
                System.out.println(i + " " + value[i]);
            }
        }
    }

    protected void Create3DemenesionalArray() {
        if (DateInInput.size() > 0) {
            for (int i = 0; i < DateInInput.size(); i++) {
                String[] date = DateInInput.get(i).split("/");
                saveChildNAC.add(date);
            }
        }
    }

    protected void showDateInArray(ArrayList<String> list) {
        for (String value : list) {
            System.out.println(value);
        }
    }

    protected void showDateInArrayNode(ArrayList<Node> list) {
        for (Node value : list) {
            System.out.println(value);
        }
    }

    protected void clearDateRepeatArray(ArrayList<String> lsit) {
        for (int i = 0; i < lsit.size(); i++) {
            if (lsit.get(i).equals(lsit.get(i + 1))) {
                lsit.remove(i);
            }
        }
    }

    protected void clearDateRepeatArrayNode(ArrayList<Node> list) {
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i).getAttributes().item(0));
        }
    }

    protected void list(NodeList listElement) {
        for (int i = 0; i < listElement.getLength(); i++) {
            showDate(listElement.item(i));
        }
        clearDateRepeatArrayNode(saveAttributeParentVC);
    }

    protected String showMetaMetaDate(Node elementList) {
        String returnDate = "";
        for (int i = 0; i < elementList.getChildNodes().getLength(); i++) {
            String temp = elementList.getChildNodes().item(i).getNodeName();
            if (!temp.equals(temp)) {
                returnDate += "\n" + elementList.getChildNodes().item(i);
            } else {
                returnDate += elementList.getChildNodes().item(i).getTextContent();
            }
        }
        return returnDate;
    }

    protected String showMetaDate(Node childElement, int counter) {
        if (!childElement.getNodeName().equals("#text")) {
            if (childElement.getChildNodes().getLength() > 2) {
                return (childElement.getNodeName() + "/" + childElement.getAttributes().item(0) + "/ " + showMetaMetaDate(childElement));
            } else {
                return (childElement.getNodeName() + "/" + childElement.getAttributes().item(0) + "/" + childElement.getTextContent());
            }
        }
        return null;
    }

    protected void showDate(Node element) {
        if (element.getNodeType() == Node.ELEMENT_NODE) {
            Node elementParrent = element;
//            Ninja Thif date
            saveParentTagName.add(elementParrent.getNodeName());
            saveAttributeParentVC.add(elementParrent.getAttributes().item(0));
//            Show Date
            System.out.println("Parent Element :" + elementParrent.getNodeName()
                    + " " + elementParrent.getAttributes().item(0));
            int counter = 0;
            while (counter < elementParrent.getChildNodes().getLength()) {
                if (showMetaDate(elementParrent.getChildNodes().item(counter), counter) != null) {
                    DateInInput.add(showMetaDate(elementParrent.getChildNodes().item(counter), counter));
                    System.out.println(showMetaDate(elementParrent.getChildNodes().item(counter), counter));
                }
                counter++;
            }
        }
    }

    public void parser(String awayToFile) {
        try {
            File inputFile = new File(awayToFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList listEmployees = doc.getElementsByTagName("employee");
            list(listEmployees);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}
