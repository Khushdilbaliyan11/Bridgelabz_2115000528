import java.util.*;
public class MaximumHandshakes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();
        System.out.println("The maximum number of handshakes is " + (numberOfStudents * (numberOfStudents - 1)) / 2);
    }
}
