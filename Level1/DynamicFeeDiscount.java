public class DynamicFeeDiscount {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter student fee: ");
        int fee = input.nextInt();
        System.out.print("Enter discount percent: ");
        int discountPercent = input.nextInt();
        int discount = (fee * discountPercent) / 100;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + (fee - discount));
    }
}