package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuPT {
    private Scanner scanner;

    public MenuPT() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("----GIai phuong trinh----");
        System.out.println("1. Phuong trinh bac mot");
        System.out.println("2. Phuong trinh bac hai");
        System.out.println("3. Exit");
    }

    public int getUserOption() {
        System.out.print("Hay chon mot: ");
        return scanner.nextInt();
    }

    public float userInput(String coefficientName) {
        float coefficient;
        while (true) {
            try {
                System.out.print("Enter " + coefficientName + ": ");
                coefficient = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Khong hop le, hay nhap mot gia tri so.");
                scanner.nextLine();
            }
        }
        return coefficient;
    }
    public void displaySolutions(List<Float> solutions) {
    if (solutions.isEmpty()) {
        System.out.println("[!] The equation has no solution [!");
    } else {
        System.out.print("Solutions: ");
        for (float solution : solutions) {
            System.out.print(solution + " and ");
        }
        if (solutions.size() == 1) {
            System.out.print("x2 = " + solutions.get(0));
        }
        System.out.println();
    }
}

public void displayProperties(List<Float> numbers, String propertyName) {
    List<Float> oddNumbers = new ArrayList<>();
    List<Float> evenNumbers = new ArrayList<>();
    List<Float> perfectSquareNumbers = new ArrayList<>();

    for (float number : numbers) {
        if (isOdd(number)) {
            oddNumbers.add(number);
        } else {
            evenNumbers.add(number);
        }

        if (isPerfectSquare(number)) {
            perfectSquareNumbers.add(number);
        }
    }

    System.out.println("Odd " + propertyName + ": " + oddNumbers);
    System.out.println("Even " + propertyName + ": " + evenNumbers);
    System.out.println("Perfect Square " + propertyName + ": " + perfectSquareNumbers);
}

public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    private boolean isOdd(float number) {
        return number % 2 != 0;
    }

    private boolean isPerfectSquare(float number) {
        float sqrt = (float) Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }
}