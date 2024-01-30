
package view;

public class CalculatorView {
    public void displayMenu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Please choose an option: ");
    }

    public void displayMemory(double memory) {
        System.out.println("Memory: " + memory);
    }

    public void displayResult(double result) {
        System.out.println("Result: " + result);
    }

    public void displayBMIResult(double bmi, String status) {
        System.out.println("BMI Number: " + bmi);
        System.out.println("BMI Status: " + status);
    }

    public void displayInvalidOption() {
        System.out.println("Invalid option. Please try again.");
    }
}
