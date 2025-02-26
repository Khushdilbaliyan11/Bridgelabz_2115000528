import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.util.Set;

class User {
    private String name;
    private int age;
    private String email;

    public User() {}

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

public class JsonEmailValidator {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String jsonFilePath = "users.json"; // Specify the path to your JSON file
        validateEmails(jsonFilePath);
    }

    private static void validateEmails(String filePath) throws Exception {
        String schemaContent = """
            {
              "$schema": "http://json-schema.org/draft-07/schema#",
              "type": "object",
              "properties": {
                "email": {
                  "type": "string",
                  "format": "email"
                }
              },
              "required": ["email"]
            }
        """;

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        JsonSchema schema = factory.getSchema(schemaContent);
        
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        if (rootNode.isArray()) {
            for (JsonNode node : rootNode) {
                Set<ValidationMessage> errors = schema.validate(node);
                if (errors.isEmpty()) {
                    System.out.println("Valid email: " + node.get("email").asText());
                } else {
                    System.out.println("Invalid email in record: " + node);
                    errors.forEach(error -> System.out.println("Error: " + error.getMessage()));
                }
            }
        } else {
            System.out.println("Provided JSON is not an array.");
        }
    }
}
