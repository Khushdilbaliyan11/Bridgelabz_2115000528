import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileWithResourcesExample {
    public static void main(String[] args) {
        String fileName = "info.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println(firstLine);
            } else {
                System.out.println("The file is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
