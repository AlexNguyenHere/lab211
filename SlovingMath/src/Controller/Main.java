package Controller;

import controller.displayPT;
import model.PhuongTrinh;
import view.MenuPT;

public class Main {
    public static void main(String[] args) {
        PhuongTrinh model = new PhuongTrinh();
        MenuPT view = new MenuPT();
        displayPT controller = new displayPT(model, view);
        controller.run();
    }
}