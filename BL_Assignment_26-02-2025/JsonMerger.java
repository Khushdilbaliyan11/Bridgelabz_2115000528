import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonMerger {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String json1 = "{\"name\": \"John Doe\", \"age\": 30}";
        String json2 = "{\"email\": \"john.doe@example.com\", \"city\": \"New York\"}";

        JsonNode mergedJson = mergeJsonObjects(json1, json2);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
    }

    private static JsonNode mergeJsonObjects(String json1, String json2) throws Exception {
        JsonNode node1 = objectMapper.readTree(json1);
        JsonNode node2 = objectMapper.readTree(json2);

        ObjectNode mergedNode = objectMapper.createObjectNode();
        mergedNode.setAll((ObjectNode) node1);
        mergedNode.setAll((ObjectNode) node2);

        return mergedNode;
    }
}
