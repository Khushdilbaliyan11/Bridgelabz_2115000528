import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}

public class EmployeeSerializationExample {
    public static void main(String[] args) {
        String fileName = "employees.ser";
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 60000));
        employees.add(new Employee(3, "Charlie", "Finance", 55000));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized successfully.");
        } catch (IOException e) {
            System.out.println("IOException during serialization: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Employees:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            System.out.println("IOException during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
    }
}
