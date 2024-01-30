
package controller;

import java.util.Scanner;
import model.BMICalculatorModel;
import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    public CalculatorModel calculatorModel;
    public BMICalculatorModel bmiCalculatorModel;
    public CalculatorView calculatorView;
    public Scanner scanner;

    public CalculatorController() {
        calculatorModel = new CalculatorModel();
        bmiCalculatorModel = new BMICalculatorModel();
        calculatorView = new CalculatorView();
        scanner = new Scanner(System.in);
    }

    public void runProgram() {
        while (true) {
            calculatorView.displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performNormalCalculator();
                    break;
                case 2:
                    performBMICalculator();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    calculatorView.displayInvalidOption();
                    break;
            }
        }
    }

    private void performNormalCalculator() {
    double memory = calculatorModel.getMemory();

    while (true) {
        System.out.print("Enter number: ");
        double number1 = scanner.nextDouble();

        System.out.print("Enter Operator (+, -, *, /, ^): ");
        String operator = scanner.next();

        System.out.print("Enter number2: ");
        double number2 = scanner.nextDouble();

        if (!operator.matches("[+\\-*/^]")) {
            System.out.println("Please input a valid operator (+, -, *, /, ^)");
            continue;
        }

        calculatorModel.performOperation(number1, operator);
        calculatorModel.performOperation(number2, operator);

        calculatorView.displayMemory(calculatorModel.getMemory());

        System.out.print("Enter Operator (= to stop): ");
        operator = scanner.next();
        if (operator.equals("=")) {
            double result = calculatorModel.getMemory();
            calculatorView.displayResult(result);
            break;
        }
    }
}

    private void performBMICalculator() {
    while (true) {
        System.out.print("Enter Weight (kg): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Weight must be a number");
            scanner.next(); // clear the invalid input
            continue;
        }
        double weight = scanner.nextDouble();

        System.out.print("Enter Height (cm): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Height must be a number");
            scanner.next(); // clear the invalid input
            continue;
        }
        double height = scanner.nextDouble() / 100; // convert cm to m

        double bmi = bmiCalculatorModel.calculateBMI(weight, height);
        String status = bmiCalculatorModel.getBMIStatus(bmi);

        calculatorView.displayBMIResult(bmi, status);

        break;
    }
    }
}