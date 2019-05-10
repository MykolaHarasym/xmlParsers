package letscode.xmlParser.service;

import org.springframework.web.multipart.MultipartFile;

public interface XmlParser {

    void parse(MultipartFile multipartFile);
}
