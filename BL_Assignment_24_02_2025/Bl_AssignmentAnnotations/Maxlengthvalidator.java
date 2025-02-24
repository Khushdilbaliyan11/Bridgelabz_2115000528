import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) 
@interface MaxLength {
    int value(); 
}

class User {
    
    @MaxLength(10)
    private String username;

    public User(String username) {
        validateMaxLength(this, username);
        this.username = username;
    }

    private void validateMaxLength(Object obj, String fieldValue) {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (fieldValue.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Error: " + field.getName() +
                            " exceeds max length of " + maxLength.value() + " characters.");
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}

public class Maxlengthvalidator {
    public static void main(String[] args) {
        try {
            User validUser = new User("divya123"); 
            System.out.println("Valid username: " + validUser.getUsername());

            User invalidUser = new User("LongUsername123");
            System.out.println("Invalid username: " + invalidUser.getUsername());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
