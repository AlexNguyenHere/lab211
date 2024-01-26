
package controller;

import model.MenuModel;
import view.MenuView;

public class MenuProgram {
    public static void main(String[] args) {
        MenuModel model = new MenuModel();
        MenuView view = new MenuView();
        MenuController controller = new MenuController(model, view);
        controller.run();
    }
}