class TriangularPark {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        double perimeter = side1 + side2 + side3;
        int rounds = (int) (5000 / perimeter);
        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km");
    }
}
