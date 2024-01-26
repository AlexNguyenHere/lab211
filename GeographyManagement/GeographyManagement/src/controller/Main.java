package controller;
import model.ManageEastAsiaCountries;
import view.ManageEastAsiaCountriesMenu;

public class Main {
    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        ManageEastAsiaCountriesMenu menu = new ManageEastAsiaCountriesMenu(manager);

        while (true) {
            menu.display();
            System.out.print("Enter your choice: ");
            int option = menu.scanner.nextInt();
            menu.handleOption(option);
        }
    }
}