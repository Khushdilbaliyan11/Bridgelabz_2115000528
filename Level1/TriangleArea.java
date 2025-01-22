import java.util.*;
public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base of triangle: ");
        double base = input.nextDouble();
        System.out.print("Enter height of triangle: ");
        double height = input.nextDouble();
        double areaInCm = 0.5 * base * height;
        double areaInInches = areaInCm / 6.452;
        System.out.println("Area in square cm: " + areaInCm + " and in square inches: " + areaInInches);
    }
}