import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class JsonToXmlConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) throws Exception {
        String jsonFilePath = "input.json";
        String xmlFilePath = "output.xml";  

        convertJsonToXml(jsonFilePath, xmlFilePath);
    }

    private static void convertJsonToXml(String jsonFilePath, String xmlFilePath) throws Exception {
        JsonNode jsonNode = objectMapper.readTree(new File(jsonFilePath));
        String xmlContent = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        xmlMapper.writeValue(new File(xmlFilePath), jsonNode);

        System.out.println("Converted XML Content:\n" + xmlContent);
    }
}
