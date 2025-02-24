import java.util.*;
public class BadWordCensor {
    public static String censorBadWords(String text, List<String> badWords) {
        for (String badWord : badWords) {
            String regex = "\\b" + badWord + "\\b";
            text = text.replaceAll(regex, "****");
        }
        return text;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> badWords = Arrays.asList("damn", "stupid");
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        String censoredText = censorBadWords(input, badWords);
        System.out.println("Censored Text:");
        System.out.println(censoredText);

        scanner.close();
    }
}
