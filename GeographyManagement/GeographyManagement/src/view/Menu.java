package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

abstract class Menu {
    protected String title;
    public List<String> options;
    public Scanner scanner;

    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addOption(String option) {
        options.add(option);
    }

    public void display() {
        System.out.println("=========================");
        System.out.println("          " + title + "         ");
        System.out.println("=========================");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println("=========================");
    }

    public abstract void handleOption(int option);
}
