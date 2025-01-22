import java.util.Scanner;

public class DistanceInputConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble();
        System.out.println("The total miles is " + (km / 1.6) + " mile for the given " + km + " km");
    }
}