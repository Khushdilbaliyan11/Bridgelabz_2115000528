import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD) 
@interface Todo {
    String task();       
    String assignedTo();  
    String priority() default "MEDIUM";  
}

class Project {
    
    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void login() {
        System.out.println("Login feature - pending task.");
    }

    @Todo(task = "Create registration page", assignedTo = "Bob")
    public void registration() {
        System.out.println("Registration page - pending task.");
    }

    @Todo(task = "Fix UI bug in homepage", assignedTo = "Charlie", priority = "LOW")
    public void fixUI() {
        System.out.println("Fixing UI bug - pending task.");
    }

    public void completedTask() {
        System.out.println("This task is already completed.");
    }
}

public class TodoProcessor {
    public static void main(String[] args) {
        Class<Project> projectClass = Project.class;

        for (Method method : projectClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned to: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("----------------------------");
            }
        }
    }
}
