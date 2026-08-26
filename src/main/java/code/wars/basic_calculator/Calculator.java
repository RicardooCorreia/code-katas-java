package code.wars.basic_calculator;

public class Calculator {

    public static Double calculate(double a, String operator, double b) {

        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> b == 0 ? null : a / b;
            default -> null;
        };
    }
}
