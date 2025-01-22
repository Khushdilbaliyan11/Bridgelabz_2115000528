class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double principal = input.nextDouble();
        double rate = input.nextDouble();
        double time = input.nextDouble();
        double interest = (principal * rate * time) / 100;
        System.out.println("The Simple Interest is " + interest + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
    }
}