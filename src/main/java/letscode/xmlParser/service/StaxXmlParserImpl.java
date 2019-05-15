package letscode.xmlParser.service;

import letscode.xmlParser.entity.Employee;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxXmlParserImpl implements  XmlParser {

    List<Employee> empList;

    final private String FILE_PATH = "src\\main\\resources\\employees.xml";

    @Override
    public List<Employee> parse(){
        empList = parseXML(FILE_PATH);
        return empList;
    }

    private static List<Employee> parseXML(String fileName) {
        List<Employee> empList = new ArrayList<>();
        Employee emp = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    if ("Employee".equals(startElement.getName().getLocalPart())){
                        emp = new Employee();
                        //Get the 'id' attribute from Employee element
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if(idAttr != null){
                            emp.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    }
                    //set the other varibles from xml elements
                    else if(startElement.getName().getLocalPart().equals("age")){
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("name")){
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setName(xmlEvent.asCharacters().getData());
                    }else if(startElement.getName().getLocalPart().equals("gender")){
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setGender(xmlEvent.asCharacters().getData());
                    }else if(startElement.getName().getLocalPart().equals("role")){
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setRole(xmlEvent.asCharacters().getData());
                    }
                }
                //if Employee end element is reached, add employee object to list
                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("Employee")){
                        empList.add(emp);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return empList;
    }
}
