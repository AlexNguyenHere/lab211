package controller;

import java.util.Arrays;
import model.PhuongTrinh;
import view.MenuPT;

public class displayPT {
    private PhuongTrinh model;
    private MenuPT view;

    public displayPT(PhuongTrinh model, MenuPT view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.displayMenu();
            int option = view.getUserOption();
            switch (option) {
                case 1:
                    giaiPTbacmot();
                    break;
                case 2:
                    giaiPTbachai();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    view.displayErrorMessage("Choice is not correct");
                    break;
            }
        }
    }

    private void giaiPTbacmot() {
        float a = view.userInput("a");
        float b = view.userInput("b");

        view.displaySolutions(model.giaiPTbacmot(a, b));
        view.displayProperties(Arrays.asList(a, b), "is");
    }

    private void giaiPTbachai() {
        float a = view.userInput("a");
        float b = view.userInput("b");
        float c = view.userInput("c");

        view.displaySolutions(model.giaiPTbacHai(a, b, c));
        view.displayProperties(Arrays.asList(a, b, c), "");
    }
}