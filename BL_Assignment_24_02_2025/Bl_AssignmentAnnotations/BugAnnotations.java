import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class) 
@interface BugReport {
    String description();
    String reportedBy();
}

class SoftwareModule {
    
    @BugReport(description = "Null pointer exception on edge case", reportedBy = "Alice")
    @BugReport(description = "Performance issue when handling large input", reportedBy = "Bob")
    public void processTask() {
        System.out.println("Processing task...");
    }
}

public class BugAnnotations{
    public static void main(String[] args) {
        Class<SoftwareModule> obj = SoftwareModule.class;
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);
                System.out.println("Method: " + method.getName());
                for (BugReport bug : bugReports.value()) {
					System.out.println("Bug discription is"+bug.description());
					System.out.println("Bug reported by "+bug.reportedBy());

                }
            }
        }
    }
}
