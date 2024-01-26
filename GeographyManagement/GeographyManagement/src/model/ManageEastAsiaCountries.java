package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManageEastAsiaCountries {
    public List<EastAsiaCountries> countryList;

    public ManageEastAsiaCountries() {
        this.countryList = new ArrayList<>();
    }

    public void addCountryInformation(EastAsiaCountries country) {
        countryList.add(country);
    }

    public EastAsiaCountries getRecentlyEnteredInformation() {
        if (countryList.isEmpty()) {
            throw new IllegalStateException("No country information entered yet.");
        }
        return countryList.get(countryList.size() - 1);
    }

    public List<EastAsiaCountries> searchInformationByName(String name) {
        List<EastAsiaCountries> searchResults = new ArrayList<>();
        for (EastAsiaCountries country : countryList) {
            if (country.getName().equalsIgnoreCase(name)) {
                searchResults.add(country);
            }
        }
        return searchResults;
    }

    public List<EastAsiaCountries> sortInformationByAscendingOrder() {
        List<EastAsiaCountries> sortedList = new ArrayList<>(countryList);
        Collections.sort(sortedList, (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return sortedList;
    }
}