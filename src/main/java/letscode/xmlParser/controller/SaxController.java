package letscode.xmlParser.controller;

import letscode.xmlParser.sax_parser.Employee;
import letscode.xmlParser.sax_parser.MyHandler;
import letscode.xmlParser.service.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("sax")
public class SaxController {

    private final XmlParser xmlParser;

    private List<Employee> empList;

    final private String FILE_PATH = "src\\main\\resources\\employees.xml";

    @Autowired
    public SaxController(@Qualifier("staxService") XmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    @GetMapping
    public List<Employee> getList() {
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
