package letscode.xmlParser.controller;

import letscode.xmlParser.entity.Employee;
import letscode.xmlParser.exception.NotFoundException;
import letscode.xmlParser.service.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("dom")
public class DomController {

    private final XmlParser xmlParser;

    @Autowired
    public DomController(@Qualifier("domImpl") XmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    @GetMapping
    public List<Employee> getList() {
        return xmlParser.parse();
    }


}




