import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {

        System.out.println("Executing fast method...");
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Executing slow method...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void normalMethod() {
        System.out.println("Executing normal method (not logged)...");
    }
}

public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        PerformanceTest obj = new PerformanceTest();
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(obj); 
                long endTime = System.nanoTime();
                long executionTime = (endTime - startTime) / 1000000; 
                System.out.println("Method: " + method.getName() + " executed in " + executionTime + " ms");
              
            }
        }
    }
}
