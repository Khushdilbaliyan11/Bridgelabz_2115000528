import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    private Student head;
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addAtPosition(int rollNumber, String name, int age, char grade, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head, prev = null;
        while (temp != null && temp.rollNumber != rollNumber) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Student not found.");
            return;
        }
        prev.next = temp.next;
    }
    public void searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
    public void updateGrade(int rollNumber, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Specific Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Display All Students");
            System.out.println("7. Update Student Grade");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int roll1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age1 = scanner.nextInt();
                    System.out.print("Enter Grade: ");
                    char grade1 = scanner.next().charAt(0);
                    studentList.addAtBeginning(roll1, name1, age1, grade1);
                    break;
                case 2:
                    System.out.print("Enter Roll Number: ");
                    int roll2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age2 = scanner.nextInt();
                    System.out.print("Enter Grade: ");
                    char grade2 = scanner.next().charAt(0);
                    studentList.addAtEnd(roll2, name2, age2, grade2);
                    break;
                case 3:
                    System.out.print("Enter Roll Number: ");
                    int roll3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age3 = scanner.nextInt();
                    System.out.print("Enter Grade: ");
                    char grade3 = scanner.next().charAt(0);
                    System.out.print("Enter Position: ");
                    int position = scanner.nextInt();
                    studentList.addAtPosition(roll3, name3, age3, grade3, position);
                    break;
                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    int delRoll = scanner.nextInt();
                    studentList.deleteByRollNumber(delRoll);
                    break;
                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = scanner.nextInt();
                    studentList.searchByRollNumber(searchRoll);
                    break;
                case 6:
                    studentList.displayAll();
                    break;
                case 7:
                    System.out.print("Enter Roll Number to update grade: ");
                    int updateRoll = scanner.nextInt();
                    System.out.print("Enter new Grade: ");
                    char newGrade = scanner.next().charAt(0);
                    studentList.updateGrade(updateRoll, newGrade);
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
