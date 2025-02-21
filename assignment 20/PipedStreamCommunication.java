import java.io.*;

public class PipedStreamCommunication {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis;

        try {
            pis = new PipedInputStream(pos);
        } catch (IOException e) {
            System.out.println("Error connecting piped streams: " + e.getMessage());
            return;
        }

        Thread writerThread = new Thread(() -> {
            try (pos) {
                String message = "Hello from the writer thread!";
                pos.write(message.getBytes());
                System.out.println("Writer: Data written to the stream.");
            } catch (IOException e) {
                System.out.println("Writer: IOException occurred: " + e.getMessage());
            }
        });

        Thread readerThread = new Thread(() -> {
            try (pis) {
                byte[] buffer = new byte[1024];
                int bytesRead = pis.read(buffer);
                String receivedMessage = new String(buffer, 0, bytesRead);
                System.out.println("Reader: Data received from the stream: " + receivedMessage);
            } catch (IOException e) {
                System.out.println("Reader: IOException occurred: " + e.getMessage());
            }
        });

        writerThread.start();
        readerThread.start();

        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
    }
}