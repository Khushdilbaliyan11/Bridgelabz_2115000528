import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonFieldExtractor {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String jsonFilePath = "user_data.json";
        extractSpecificFields(jsonFilePath);
    }

    private static void extractSpecificFields(String filePath) throws Exception {
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        if (rootNode.isArray()) {
            for (JsonNode node : rootNode) {
                String name = node.has("name") ? node.get("name").asText() : "N/A";
                String email = node.has("email") ? node.get("email").asText() : "N/A";
                System.out.println("Name: " + name + ", Email: " + email);
            }
        } else {
            String name = rootNode.has("name") ? rootNode.get("name").asText() : "N/A";
            String email = rootNode.has("email") ? rootNode.get("email").asText() : "N/A";
            System.out.println("Name: " + name + ", Email: " + email);
        }
    }
}