class TemperatureConversionFtoC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fahrenheit = input.nextDouble();
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("The " + fahrenheit + " fahrenheit is " + celsius + " celsius");
    }
}