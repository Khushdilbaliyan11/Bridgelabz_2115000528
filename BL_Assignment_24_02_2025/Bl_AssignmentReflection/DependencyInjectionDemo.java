import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    public void execute() {
        System.out.println("Service executed!");
    }
}

class Client {
    @Inject
    private Service service;

    public void run() {
        service.execute();
    }
}

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) {
        try {
            if (instances.containsKey(clazz)) {
                return clazz.cast(instances.get(clazz));
            }

            Constructor<T> constructor = clazz.getDeclaredConstructor();
            T instance = constructor.newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    Object dependency = getInstance(field.getType());
                    field.set(instance, dependency);
                }
            }

            instances.put(clazz, instance);
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance for: " + clazz, e);
        }
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        Client client = container.getInstance(Client.class);
        client.run();
    }
}
