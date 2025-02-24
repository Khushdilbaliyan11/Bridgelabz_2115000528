import java.lang.reflect.Field;
import java.util.Map;

class Person {
    private String name;
    private int age;

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Object mapping failed", e);
        }
    }

    public static void main(String[] args) {
        Map<String, Object> personData = Map.of("name", "John Doe", "age", 30);

        Person person = toObject(Person.class, personData);
        person.display();
    }
}
