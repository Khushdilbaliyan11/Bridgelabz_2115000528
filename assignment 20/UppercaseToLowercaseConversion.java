import java.io.*;

public class UppercaseToLowercaseConversion {
    public static void main(String[] args) {
        String sourceFile = "source_text.txt";
        String destinationFile = "converted_text.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destinationFile), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File has been converted to lowercase and saved successfully.");

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
