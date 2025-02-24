import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

class SecureService {

    @RoleAllowed("ADMIN") 
    public void adminTask() {
        System.out.println("Admin task executed successfully.");
    }

    @RoleAllowed("USER") 
    public void userTask() {
        System.out.println("User task executed successfully.");
    }

    public void publicTask() {
        System.out.println("Public task executed by anyone.");
    }
}

public class RoleBasedAccessControl {
    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        SecureService service = new SecureService();

        executeMethodIfAllowed(service, "adminTask", adminUser);
        executeMethodIfAllowed(service, "adminTask", normalUser); 
        executeMethodIfAllowed(service, "userTask", normalUser); 
        executeMethodIfAllowed(service, "publicTask", normalUser); 
    }

    private static void executeMethodIfAllowed(Object obj, String methodName, User user) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (!roleAllowed.value().equals(user.getRole())) {
                    System.out.println("Access Denied! " + user.getRole() + " is not allowed to execute " + methodName);
                    return;
                }
            }
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
