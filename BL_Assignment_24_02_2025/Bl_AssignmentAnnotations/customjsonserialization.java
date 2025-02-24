import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD)
@interface JsonField {
    String name(); 
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    public User(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonMap = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);

                if (field.isAnnotationPresent(JsonField.class)) {
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonMap.put(annotation.name(), field.get(obj).toString());
                }
            }

            StringBuilder jsonBuilder = new StringBuilder("{");
            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                jsonBuilder.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
            }
            if (jsonBuilder.length() > 1) jsonBuilder.setLength(jsonBuilder.length() - 2);
            jsonBuilder.append("}");

            return jsonBuilder.toString();

        } catch (IllegalAccessException e) {
            throw new RuntimeException("JSON Serialization failed!", e);
        }
    }
}

public class customjsonserialization {
    public static void main(String[] args) {
        User user = new User("JohnDoe", 30, "john.doe@example.com");
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
