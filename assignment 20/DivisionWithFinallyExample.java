import java.util.Scanner;

public class DivisionWithFinallyExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the first integer: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the second integer: ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}