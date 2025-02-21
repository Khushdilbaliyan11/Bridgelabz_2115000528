import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWriteExample {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }
            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
