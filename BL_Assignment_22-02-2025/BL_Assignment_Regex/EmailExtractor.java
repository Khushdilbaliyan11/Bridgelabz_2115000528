import java.util.regex.*;
import java.util.*;

public class EmailExtractor {
    public static List<String> extractEmails(String text) {
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> emails = new ArrayList<>();
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org for details.";
        List<String> emails = extractEmails(text);
        if (emails.isEmpty()) {
            System.out.println("No emails found.");
        } else {
            System.out.println("Extracted Emails:");
            for (String email : emails) {
                System.out.println(email);
            }
        }
    }
}
