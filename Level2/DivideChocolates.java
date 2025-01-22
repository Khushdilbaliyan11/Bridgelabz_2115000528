class DivideChocolates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfChocolates = input.nextInt();
        int numberOfChildren = input.nextInt();
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        System.out.println("The number of chocolates each child gets is " + chocolatesPerChild + " and the number of remaining chocolates are " + remainingChocolates);
    }
}
