import java.util.Scanner;

public class SpaceNormalizer {
    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence with extra spaces: ");
        String input = scanner.nextLine();

        String normalizedText = replaceMultipleSpaces(input);

        System.out.println("Normalized Text:");
        System.out.println(normalizedText);

        scanner.close();
    }
}
