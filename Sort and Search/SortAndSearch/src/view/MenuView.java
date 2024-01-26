package view;

import java.util.Arrays;
import java.util.Scanner;

public class MenuView {
    public int getMenuChoiceFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Search");
        System.out.println("2. Sort");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of array: ");
        return scanner.nextInt();
    }

    public int getSortingMethodFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a sorting method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.print("Enteryour choice: ");
        return scanner.nextInt();
    }

    public int getSearchMethodFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a search method:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public int getTargetFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target value to search for: ");
        return scanner.nextInt();
    }

    public void displayArray(int[] array) {
        System.out.print("Unsorted array: ");
        displayArrayElements(array);
    }

    public void displaySortedArray(int[] array) {
        System.out.print("Sorted array: ");
        displayArrayElements(array);
    }

    private void displayArrayElements(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}