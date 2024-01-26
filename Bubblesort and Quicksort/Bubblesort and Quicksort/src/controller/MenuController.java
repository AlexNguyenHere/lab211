package controller;

import java.util.Arrays;
import model.MenuModel;
import view.MenuView;

public class MenuController {
    private MenuModel model;
    private MenuView view;

    public MenuController(MenuModel model, MenuView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        int number = view.getNumberFromUser();
        int sortingMethod = view.getSortingMethodFromUser();

        generateRandomArray(number);
        sortArray(sortingMethod);

        view.displayArray(model.getArray());
        view.displaySortedArray(model.getSortedArray());

        int searchMethod = view.getSearchMethodFromUser();
        int searchValue = view.getSearchValueFromUser();

        int searchResult;
        if (searchMethod == 1) {
            searchResult = binarySearch(model.getSortedArray(), searchValue);
        } else {
            searchResult = linearSearch(model.getSortedArray(), searchValue);
        }

        view.displaySearchResult(searchResult);
    }

    private void generateRandomArray(int number) {
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        model.setArray(array);
    }

    private void sortArray(int sortingMethod) {
        int[] array = Arrays.copyOf(model.getArray(), model.getArray().length);

        switch (sortingMethod) {
            case 1:
                bubbleSort(array);
                break;
            case 2:
                quickSort(array, 0, array.length - 1);
                break;
            default:
                System.out.println("Invalid sorting method chosen. Using Bubble Sort by default.");
                bubbleSort(array);
                break;
        }

        model.setSortedArray(array);
    }

    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {   
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private int binarySearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == value) {
                return mid;
            }

            if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Value not found
    }

    private int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1; // Value not found
    }
}