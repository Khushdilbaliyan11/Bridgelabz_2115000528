import java.io.*;

public class StudentDataStorage {
    public static void main(String[] args) {
        String fileName = "student_data.bin";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.6);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(3.9);

            System.out.println("Student details have been stored successfully.");
        } catch (IOException e) {
            System.out.println("IOException while writing data: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Retrieved Student Details:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("IOException while reading data: " + e.getMessage());
        }
    }
}
