import java.io.*;
import java.util.*;
import java.util.stream.*;

public class WordCountTopFive {
    public static void main(String[] args) {
        String filePath = "text_file.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            System.out.println("Top 5 most frequently occurring words:");
            wordCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

            System.out.println("Total unique words: " + wordCountMap.size());

        } catch (IOException e) {
            System.out.println("IOException occurred while reading the file: " + e.getMessage());
        }
    }
}
