package letscode.xmlParser.service;

import letscode.xmlParser.entity.Employee;
import letscode.xmlParser.sax_handler.MyHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaxXmlParserImpl implements XmlParser {

    private List<Employee> empList;

    final private String FILE_PATH = "src\\main\\resources\\employees.xml";

    @Override
    public List<Employee> parse() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File(FILE_PATH), handler);
            //Get Employees list
            empList = handler.getEmpList();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return empList;

    }
}
