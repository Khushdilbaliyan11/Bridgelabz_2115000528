import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority(); 
    String assignedTo(); 
}

class TaskManager {
    
    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Completing high-priority task...");
    }

    @TaskInfo(priority = "Low", assignedTo = "Bob")
    public void reviewTask() {
        System.out.println("Reviewing low-priority task...");
    }
}

public class AnnotationsProcessor {
    public static void main(String[] args) {
        
        Class<TaskManager> obj = TaskManager.class;
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(TaskInfo.class)) {
                
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        }
    }
}
