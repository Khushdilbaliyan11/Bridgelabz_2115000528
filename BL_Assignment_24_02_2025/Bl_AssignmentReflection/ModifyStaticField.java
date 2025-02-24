import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static void printApiKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            Class<?> configClass = Configuration.class;
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            apiKeyField.setAccessible(true);
            apiKeyField.set(null, "NEW_SECURE_KEY");

            Configuration.printApiKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
