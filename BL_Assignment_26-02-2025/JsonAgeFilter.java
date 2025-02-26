import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.*;

class Person {
    private String name;
    private int age;
    private String email;

    public Person() {}

    public Person(String name, int age, String email) {
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

public class JsonAgeFilter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String jsonFilePath = "persons.json";
        filterRecordsByAge(jsonFilePath, 25);
    }

    private static void filterRecordsByAge(String filePath, int ageThreshold) throws Exception {
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        if (rootNode.isArray()) {
            for (JsonNode node : rootNode) {
                int age = node.has("age") ? node.get("age").asInt() : 0;
                if (age > ageThreshold) {
                    String name = node.has("name") ? node.get("name").asText() : "N/A";
                    String email = node.has("email") ? node.get("email").asText() : "N/A";
                    System.out.println("Name: " + name + ", Age: " + age + ", Email: " + email);
                }
            }
        } else {
            System.out.println("Provided JSON is not an array.");
        }
    }
}