import java.util.Scanner;

public class IPAddressValidator {
    public static boolean isValidIPv4(String ip) {
        String regex = 
            "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}" +  
            "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$"; 
        return ip.matches(regex);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IPv4 address: ");
        String ip = scanner.nextLine();
        if (isValidIPv4(ip)) {
            System.out.println("Valid IPv4 Address");
        } else {
            System.out.println("Invalid IPv4 Address");
        }
        scanner.close();
    }
}
