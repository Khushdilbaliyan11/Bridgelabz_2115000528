import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static Set<String> findRepeatingWords(String text) {
        String regex = "\\b(\\w+)\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> repeatingWords = new HashSet<>();

        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            if (wordCount.get(word) > 1) {
                repeatingWords.add(word);
            }
        }
        return repeatingWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        Set<String> repeatedWords = findRepeatingWords(text);

        if (repeatedWords.isEmpty()) {
            System.out.println("No repeating words found.");
        } else {
            System.out.println("Repeating Words:");
            System.out.println(String.join(", ", repeatedWords));
        }
    }
}
