class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        System.out.println("The results of Int Operations are " + (a + b * c) + ", " + (a * b + c) + ", " + (c + a / b) + ", and " + (a % b + c));
    }
}