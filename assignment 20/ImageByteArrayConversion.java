import java.io.*;
import java.util.Arrays;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        String sourceImage = "source_image.jpg";
        String destinationImage = "copied_image.jpg";

        try (FileInputStream fis = new FileInputStream(sourceImage);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(destinationImage)) {

                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("Image has been converted to byte array and copied successfully.");
            }

            boolean isIdentical = compareFiles(sourceImage, destinationImage);
            if (isIdentical) {
                System.out.println("Verification successful: The copied image is identical to the original.");
            } else {
                System.out.println("Verification failed: The copied image differs from the original.");
            }

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    private static boolean compareFiles(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {

            byte[] buffer1 = new byte[4096];
            byte[] buffer2 = new byte[4096];

            int bytesRead1, bytesRead2;
            while ((bytesRead1 = fis1.read(buffer1)) != -1) {
                bytesRead2 = fis2.read(buffer2);
                if (bytesRead1 != bytesRead2 || !Arrays.equals(buffer1, buffer2)) {
                    return false;
                }
            }
            return fis2.read() == -1;
        }
    }
}