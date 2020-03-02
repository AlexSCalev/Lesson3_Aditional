package ParsingAndCreate;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Dom_CreateXML {

    ArrayList<String> saveParentTagName = new ArrayList<>();
    ArrayList<Node> saveAttributeParentVC = new ArrayList<>();
    ArrayList<String[]> saveChildNAC = new ArrayList<>();

    public void inputFile(String awayToFileResources, String awayToFileCreate0, String awayToFileCreate1) {
        Dom_Parsing createArrays = new Dom_Parsing();
        createArrays.parser(awayToFileResources);
        createArrays.Create3DemenesionalArray();
        this.saveChildNAC = createArrays.saveChildNAC;
        this.saveParentTagName = createArrays.saveParentTagName;
        this.saveAttributeParentVC = createArrays.saveAttributeParentVC;
        createFile(awayToFileCreate0,awayToFileCreate1);
    }

    public void createFile(String awayToFile0, String awayToFile1) {
        try {
            DocumentBuilderFactory dbFactory0 = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder0 = dbFactory0.newDocumentBuilder();
            Document doc0 = dBuilder0.newDocument();
            Element rootElement0 = doc0.createElement("Employees");
            doc0.appendChild(rootElement0);

            DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
            Document doc1 = dBuilder1.newDocument();
            Element rootElement1 = doc1.createElement("Employees");
            doc1.appendChild(rootElement1);

// Create Element one
            Element parentElement0 = doc0.createElement(saveParentTagName.get(0));
            rootElement0.appendChild(parentElement0);
            Attr attr = doc0.createAttribute(saveAttributeParentVC.get(0).getNodeName());
            attr.setValue(saveAttributeParentVC.get(0).getNodeValue());
            parentElement0.setAttributeNode(attr);
//Add Child One
            Element childElement0 = doc0.createElement(saveChildNAC.get(0)[0]);
            childElement0.appendChild(doc0.createTextNode(saveChildNAC.get(0)[2]));
            parentElement0.appendChild(childElement0);

            Element childElement1 = doc0.createElement(saveChildNAC.get(1)[0]);
            childElement1.appendChild(doc0.createTextNode(saveChildNAC.get(1)[2]));
            parentElement0.appendChild(childElement1);

            Element childElement2 = doc0.createElement(saveChildNAC.get(2)[0]);
            childElement2.appendChild(doc0.createTextNode(saveChildNAC.get(2)[2]));
            parentElement0.appendChild(childElement2);

            Element childElement3 = doc0.createElement(saveChildNAC.get(3)[0]);
            childElement3.appendChild(doc0.createTextNode(saveChildNAC.get(3)[2]));
            parentElement0.appendChild(childElement3);

            Element childElement4 = doc0.createElement(saveChildNAC.get(4)[0]);
            childElement4.appendChild(doc0.createTextNode(saveChildNAC.get(4)[2]));
            parentElement0.appendChild(childElement4);

            Element childElement5 = doc0.createElement(saveChildNAC.get(5)[0]);
            childElement5.appendChild(doc0.createTextNode(saveChildNAC.get(5)[2]));
            parentElement0.appendChild(childElement5);
// Create Element two
            Element parentElement1 = doc1.createElement(saveParentTagName.get(1));
            rootElement1.appendChild(parentElement1);
            Attr attr1 = doc1.createAttribute(saveAttributeParentVC.get(1).getNodeName());
            attr1.setValue(saveAttributeParentVC.get(1).getNodeValue());
            parentElement1.setAttributeNode(attr1);
// Create Child Element
            Element childElement6 = doc1.createElement(saveChildNAC.get(6)[0]);
            childElement6.appendChild(doc1.createTextNode(saveChildNAC.get(6)[2]));
            parentElement1.appendChild(childElement6);

            Element childElement7 = doc1.createElement(saveChildNAC.get(7)[0]);
            childElement7.appendChild(doc1.createTextNode(saveChildNAC.get(7)[2]));
            parentElement1.appendChild(childElement7);

            Element childElement8 = doc1.createElement(saveChildNAC.get(8)[0]);
            childElement8.appendChild(doc1.createTextNode(saveChildNAC.get(8)[2]));
            parentElement1.appendChild(childElement8);

            Element childElement9 = doc1.createElement(saveChildNAC.get(9)[0]);
            childElement9.appendChild(doc1.createTextNode(saveChildNAC.get(9)[2]));
            parentElement1.appendChild(childElement9);

            Element childElement10 = doc1.createElement(saveChildNAC.get(10)[0]);
            childElement10.appendChild(doc1.createTextNode(saveChildNAC.get(10)[2]));
            parentElement1.appendChild(childElement10);

            Element childElement11 = doc1.createElement(saveChildNAC.get(11)[0]);
            childElement11.appendChild(doc1.createTextNode(saveChildNAC.get(11)[2]));
            parentElement1.appendChild(childElement11);


//            Create XML File use Trasforms
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer trasformer = transformerFactory.newTransformer();
            DOMSource source0 = new DOMSource(doc0);
            DOMSource source1 = new DOMSource(doc1);
//            Indicate directory
            StreamResult result = new StreamResult(new File(awayToFile0));
            StreamResult result1 = new StreamResult(new File(awayToFile1));
            trasformer.transform(source0, result);
            trasformer.transform(source1, result1);

        } catch (Exception e) {
            e.fillInStackTrace();
        }

    }
}
