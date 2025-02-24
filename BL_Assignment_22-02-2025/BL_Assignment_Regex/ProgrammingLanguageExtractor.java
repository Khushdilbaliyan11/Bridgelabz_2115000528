import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
    public static List<String> extractLanguages(String text) {
        List<String> languages = Arrays.asList("JavaScript", "Java", "Python", "C++", "C#", "Go", "Ruby", "Swift", "Kotlin", "PHP", "R", "TypeScript");
        List<String> extractedLanguages = new ArrayList<>();
        for (String language : languages) {
            String regex = "\\b" + language + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                extractedLanguages.add(language);
            }
        }
        return extractedLanguages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> extractedLanguages = extractLanguages(text);

        if (extractedLanguages.isEmpty()) {
            System.out.println("No programming languages found.");
        } else {
            System.out.println("Extracted Programming Languages:");
            System.out.println(String.join(", ", extractedLanguages));
        }
    }
}
