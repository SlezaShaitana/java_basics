import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {
    private int limit = 5_000_000;
    int number = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("voter") && number < limit) {
            String birthdayDate = attributes.getValue("birthDay");
            String name = attributes.getValue("name");
            try {
                DBConnection.countVoter(name, birthdayDate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            number++;
        }
    }
}
