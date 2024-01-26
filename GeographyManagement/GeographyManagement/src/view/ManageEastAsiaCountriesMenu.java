package view;

import java.util.List;
import model.EastAsiaCountries;
import model.ManageEastAsiaCountries;
import view.ManageEastAsiaCountriesMenu;

public class ManageEastAsiaCountriesMenu extends Menu {
    public ManageEastAsiaCountries manager;

    public ManageEastAsiaCountriesMenu(ManageEastAsiaCountries manager) {
        super("MENU");
        this.manager = manager;
        addOption("Input the information of 11 countries in East Asia");
        addOption("Display the information of the country you've just input");
        addOption("Search the information of a country by user-entered name");
        addOption("Display the information of countries sorted by name in ascending order");
        addOption("Exit");
    }

    @Override
    public void handleOption(int option) {
        switch (option) {
            case 1:
    try {
        for (int i = 0; i < 11; i++) {
            System.out.println("Enter information for country " + (i + 1) + ":");
            System.out.print("Country Code: ");
            String code = scanner.next();
            System.out.print("Country Name: ");
            String name = scanner.next();
            System.out.print("Total Area: ");
            float area = scanner.nextFloat();
            System.out.print("Country Terrain: ");
            String terrain = scanner.next();

            EastAsiaCountries country = new EastAsiaCountries(code, name, area, terrain);
            manager.addCountryInformation(country);
        }
    } catch (Exception e) {
        System.out.println("Invalid input. Please try again.");
    }
    break;
            case 2:
                try {
                    EastAsiaCountries recentlyEnteredCountry = manager.getRecentlyEnteredInformation();
                    System.out.println("Recently entered country information:");
                    recentlyEnteredCountry.display();
                }
                catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.print("Enter the name of the country to search: ");
                String searchName = scanner.next();
                List<EastAsiaCountries> searchResults = manager.searchInformationByName(searchName);
                if (searchResults.isEmpty()) {
                    System.out.println("No countries found with the entered name.");
                } else {
                    System.out.println("Search results for " + searchName + ":");
                    for (EastAsiaCountries country : searchResults) {
                        country.display();
                    }
                }
                break;
            case 4:
                List<EastAsiaCountries> sortedList = manager.sortInformationByAscendingOrder();
                System.out.println("Countries sorted by name in ascending order:");
                for (EastAsiaCountries country : sortedList) {
                    country.display();
                }
                break;
            case 5:
                System.out.println("Exiting program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }
}