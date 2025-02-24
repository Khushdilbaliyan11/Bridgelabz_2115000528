import java.util.Scanner;

public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        String visaRegex = "^4\\d{15}$";
        String masterCardRegex = "^5\\d{15}$";
        return cardNumber.matches(visaRegex) || cardNumber.matches(masterCardRegex);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a credit card number: ");
        String cardNumber = scanner.nextLine();

        if (isValidCreditCard(cardNumber)) {
            System.out.println("Valid Credit Card Number");
        } else {
            System.out.println("Invalid Credit Card Number");
        }

        scanner.close();
    }
}
