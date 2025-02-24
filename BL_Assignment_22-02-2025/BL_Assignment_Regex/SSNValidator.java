import java.util.Scanner;
import java.util.regex.*;
public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        String regex = "^(\\d{3}-\\d{2}-\\d{4})$";
        return ssn.matches(regex);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Social Security Number (SSN): ");
        String input = scanner.nextLine();

        if (isValidSSN(input)) {
            System.out.println("\"" + input + "\" is a valid SSN.");
        } else {
            System.out.println("\"" + input + "\" is an invalid SSN.");
        }
        scanner.close();
    }
}
