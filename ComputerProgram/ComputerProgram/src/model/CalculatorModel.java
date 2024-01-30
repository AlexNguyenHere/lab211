package model;

public class CalculatorModel {
    private double memory;

    public double getMemory() {
        return memory;
    }

    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            case POWER:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public void performOperation(double number, String operator) {
        switch (operator) {
            case "+":
                memory += number;
                break;
            case "-":
                memory -= number;
                break;
            case "*":
                memory *= number;
                break;
            case "/":
                memory /= number;
                break;
            case "^":
                memory = Math.pow(memory, number);
                break;
        }
    }

public enum Operator {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    POWER("^");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
}