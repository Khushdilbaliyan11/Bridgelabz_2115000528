import java.io.*;

public class LargeFileErrorReader {
    public static void main(String[] args) {
        String filePath = "large_text_file.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
            System.out.println("Finished reading the file.");
        } catch (IOException e) {
            System.out.println("IOException occurred while reading the file: " + e.getMessage());
        }
    }
}
