package letscode.xmlParser;

import letscode.xmlParser.service.SaxXmlParserImpl;
import letscode.xmlParser.service.XmlParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigurations {

    @Bean("saxImpl")
    XmlParser saxServiceImpl() {
        return new SaxXmlParserImpl();
    }
}
