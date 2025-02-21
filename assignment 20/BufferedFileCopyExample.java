import java.io.*;

public class BufferedFileCopyExample {
    public static void main(String[] args) {
        String sourceFile = "source_large.txt";
        String destinationFileBuffered = "destination_buffered.txt";
        String destinationFileUnbuffered = "destination_unbuffered.txt";
        int bufferSize = 4096;

        // Buffered Streams
        long startBuffered = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFileBuffered))) {

            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered file copy completed.");
        } catch (IOException e) {
            System.out.println("Buffered Stream Error: " + e.getMessage());
        }
        long endBuffered = System.nanoTime();
        System.out.println("Buffered stream time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");

        // Unbuffered Streams
        long startUnbuffered = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFileUnbuffered)) {

            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Unbuffered file copy completed.");
        } catch (IOException e) {
            System.out.println("Unbuffered Stream Error: " + e.getMessage());
        }
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered stream time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");
    }
}
