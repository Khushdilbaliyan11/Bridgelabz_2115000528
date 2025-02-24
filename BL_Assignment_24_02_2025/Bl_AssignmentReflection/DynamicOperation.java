import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicOperation {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("Student");

            Constructor<?> defaultConstructor = studentClass.getDeclaredConstructor();
            Object student1 = defaultConstructor.newInstance();
            ((Student) student1).display();

            Constructor<?> paramConstructor = studentClass.getDeclaredConstructor(String.class);
            Object student2 = paramConstructor.newInstance("John Doe");
            ((Student) student2).display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
