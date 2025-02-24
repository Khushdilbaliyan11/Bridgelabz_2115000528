import java.lang.reflect.Method;

class Task {
    public void fastMethod() {
        System.out.println("Executing fast method...");
    }

    public void slowMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing slow method...");
    }
}

public class MethodExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            System.out.println(methodName + " executed in " + (endTime - startTime) / 1_000_000.0 + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        measureExecutionTime(task, "fastMethod");
        measureExecutionTime(task, "slowMethod");
    }
}
