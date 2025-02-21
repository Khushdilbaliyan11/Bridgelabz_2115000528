import java.util.Scanner;

public class ArrayOperationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] array = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter the index to retrieve the value: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}