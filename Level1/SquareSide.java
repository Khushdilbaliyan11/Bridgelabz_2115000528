import java.util.*;
public class SquareSide {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter perimeter of square: ");
        int perimeter = input.nextInt();
        System.out.println("The length of the side is " + (perimeter / 4.0) + " whose perimeter is " + perimeter);
    }
}