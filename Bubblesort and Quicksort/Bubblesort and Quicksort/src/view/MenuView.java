package view;

import java.util.Scanner;

public class MenuView {
    public int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("___MENU: ");
        System.out.print("Enter number of array: ");
        return scanner.nextInt();
    }

    public int getSortingMethodFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a sorting method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.print("Enter your choice: ");
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

    public int getSearchValueFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the search value: ");
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

    public void displaySearchResult(int index) {
        if (index == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + index);
        }
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
