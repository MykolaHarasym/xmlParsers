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
@RequestMapping("sax")
public class SaxController {

    private final XmlParser xmlParser;

    @Autowired
    public SaxController(@Qualifier("saxImpl") XmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    @GetMapping()
    public List<Employee> getList() {
        return xmlParser.parse();
    }

    @GetMapping("{id}")
    public Employee getOne(@PathVariable int id) {
        return getEmployee(id);
    }

    private List<Employee> getEmployeeList(){
        return xmlParser.parse();
    }

    private Employee getEmployee(@PathVariable int id) {
        return getEmployeeList().stream()
                .filter(employee -> employee.getId()==id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
