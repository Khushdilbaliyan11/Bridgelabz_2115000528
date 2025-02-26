import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

class Student {
    private String name;
    private int age;
    private List<String> subjects;

    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}

public class StudentJsonGenerator {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        Student student = new Student("John Doe", 20, Arrays.asList("Mathematics", "Physics", "Computer Science"));
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(jsonString);
    }
}
