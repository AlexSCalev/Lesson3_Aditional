package ParsingAndCreate;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX_Parsing {

    public void bublicSAX() {
        try {
            File inputFile = new File("C:\\Users\\Alexandr\\Desktop\\Testing\\Makler.txt");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {
    boolean bLastName = false;
    boolean bFirstName = false;
    boolean bBrithDate = false;
    boolean bPosition = false;
    boolean bSkill1 = false;
    boolean bSkill2 = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            String empId = attributes.getValue("empId");
            System.out.println("empId : " + empId);
        } else if (qName.equalsIgnoreCase("lastname")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("firstname")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("birthDate")) {
            bBrithDate = true;
        } else if (qName.equalsIgnoreCase("position")) {
            bPosition = true;
        } else if (qName.equalsIgnoreCase("skill")) {
            bSkill1 = true;
        } else if (qName.equalsIgnoreCase("skill")) {
            bSkill2 = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bLastName) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bFirstName) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bBrithDate) {
            System.out.println("birthDate : " + new String(ch, start, length));
            bBrithDate = false;
        } else if (bPosition) {
            System.out.println("Position: " + new String(ch, start, length));
            bPosition = false;
        } else if (bSkill1) {
            System.out.println("Skill 1: " + new String(ch, start, length));
            bSkill1 = false;
        } else if (bSkill2) {
            System.out.println("Skill 1: " + new String(ch, start, length));
            bSkill2 = false;
        }
    }
}
