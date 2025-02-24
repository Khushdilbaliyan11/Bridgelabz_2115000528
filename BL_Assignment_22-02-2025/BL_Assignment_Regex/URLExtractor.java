import java.util.regex.*;
import java.util.*;
public class URLExtractor{
    public static List<String> extractURLs(String text) {
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/[a-zA-Z0-9._%+-/?=&]*)?\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> urls = new ArrayList<>();
        while (matcher.find()) {
            urls.add(matcher.group());
        }
        return urls;
    }
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        List<String> urls = extractURLs(text);

        if (urls.isEmpty()) {
            System.out.println("No URLs found.");
        } else {
            System.out.println("Extracted URLs:");
            System.out.println(String.join(", ", urls));
        }
    }
}
