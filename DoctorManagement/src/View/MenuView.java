package view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView() {
        scanner = new Scanner(System.in);
    }

    public int getMenuChoice() {
        System.out.println("Menu:");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    public void displaySuccessMessage(String message) {
        System.out.println("Success: " + message);
    }

 
}