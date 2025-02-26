import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonValidator1 {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String json = "{\"name\": \"John Doe\", \"age\": 30, \"email\": \"john.doe@example.com\"}";
        
        if (isValidJson(json)) {
            System.out.println("The JSON structure is valid.");
        } else {
            System.out.println("The JSON structure is invalid.");
        }
    }

    private static boolean isValidJson(String json) {
        try {
            JsonNode node = objectMapper.readTree(json);
            return node.has("name") && node.has("age") && node.has("email");
        } catch (Exception e) {
            return false;
        }
    }
}