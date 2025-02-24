import java.lang.reflect.Field;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JsonConvertor {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                json.append("\"").append(fields[i].getName()).append("\": ");
                Object value = fields[i].get(obj);
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (i < fields.length - 1) {
                json.append(", ");
            }
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);
        String jsonString = toJson(person);
        System.out.println(jsonString);
    }
}
