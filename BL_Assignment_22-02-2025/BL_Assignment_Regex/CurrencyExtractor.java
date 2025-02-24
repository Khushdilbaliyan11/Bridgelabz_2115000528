import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor{
    public static List<String> extractCurrencyValues(String text) {
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
	}
    
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> extractedValues = extractCurrencyValues(text);

        if (extractedValues.isEmpty()) {
            System.out.println("No currency values found.");
        } else {
            System.out.println("Extracted Currency Values:");
            System.out.println(String.join(", ", extractedValues));
        }
    }
}