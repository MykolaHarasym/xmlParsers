package letscode.xmlParser.controller;

import letscode.xmlParser.entity.Employee;
import letscode.xmlParser.service.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("stax")
public class StaxController {

    private final XmlParser xmlParser;

    @Autowired
    public StaxController(@Qualifier("staxImpl") XmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    @GetMapping
    public List<Employee> getList() {
        return  xmlParser.parse();
    }
}
