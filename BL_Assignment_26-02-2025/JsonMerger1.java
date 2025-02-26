import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class JsonMerger1 {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String jsonFilePath1 = "file1.json"; // Specify the path to the first JSON file
        String jsonFilePath2 = "file2.json"; // Specify the path to the second JSON file

        JsonNode mergedJson = mergeJsonFiles(jsonFilePath1, jsonFilePath2);
        System.out.println("Merged JSON Object:\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
    }

    private static JsonNode mergeJsonFiles(String filePath1, String filePath2) throws Exception {
        JsonNode jsonNode1 = objectMapper.readTree(new File(filePath1));
        JsonNode jsonNode2 = objectMapper.readTree(new File(filePath2));

        if (jsonNode1.isObject() && jsonNode2.isObject()) {
            ObjectNode mergedNode = ((ObjectNode) jsonNode1).deepCopy();
            jsonNode2.fields().forEachRemaining(entry -> mergedNode.set(entry.getKey(), entry.getValue()));
            return mergedNode;
        } else {
            throw new IllegalArgumentException("Both JSON files must contain JSON objects.");
        }
    }
}
