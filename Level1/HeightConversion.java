import java.util.Scanner;
public class HeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter height in cm: ");
        double heightCm = input.nextDouble();
        double heightInches = heightCm / 2.54;
        double heightFeet = Math.floor(heightInches / 12);
        heightInches %= 12;
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + heightFeet + " and inches is " + heightInches);
    }
}