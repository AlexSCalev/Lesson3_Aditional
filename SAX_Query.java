package ParsingAndCreate;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX_Query {

    public void bublicCreateQuery(String awayToFile) {
        try {
            File inputFile = new File(awayToFile);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandl extends DefaultHandler {

    boolean bLastName = false;
    boolean bFirstName = false;
    boolean bBrithDate = false;
    boolean bPosition = false;
    boolean bSkill1 = false;
    boolean bSkill2 = false;
    String attribute = null;

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            attribute = attributes.getValue("empId");
        }
        if (("001").equals(attribute) && qName.equalsIgnoreCase("employee")) {
            System.out.println("Start Element :" + qName);
        }
        if (qName.equalsIgnoreCase("lastName")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("firstName")) {
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
    public void endElement(
            String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {

            if (("001").equals(attribute)
                    && qName.equalsIgnoreCase("employee"))
                System.out.println("End Element :" + qName);
        }
    }


    @Override
    public void characters(
            char ch[], int start, int length) throws SAXException {

        if (bLastName && ("001").equals(attribute)) {
            //age element, set Employee age
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bFirstName && ("001").equals(attribute)) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bBrithDate && ("001").equals(attribute)) {
            System.out.println("Brith Date: " + new String(ch, start, length));
            bBrithDate = false;
        } else if (bPosition && ("001").equals(attribute)) {
            System.out.println("Position: " + new String(ch, start, length));
            bPosition = false;
        } else if (bSkill1 && ("001").equals(attribute)) {
            System.out.println("Skill1:" + new String(ch, start, length));
            bSkill1 = false;
        } else if (bSkill2 && ("001").equals(attribute)) {
            System.out.println("Skill2:" + new String(ch, start, length));
            bSkill2 = false;
        }
    }
}
