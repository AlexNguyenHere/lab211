package view;

import model.Doctor;

import java.util.HashMap;

public class DoctorView {
    public void displayDoctor(Doctor doctor) {
    System.out.printf("%-6s %-10s %-20s %-13s\n", "Code", "Name", "Specialization", "Availability");
    System.out.printf("%-6s %-10s %-20s %-13d\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
   
}
  

    public void displaySearchResults(HashMap<String, Doctor> searchResults) {
        if (searchResults.isEmpty()) {
            System.out.println("No doctors found for the given search input.");
        } else {
           System.out.println("---------- Result ----------");
            for (Doctor doctor : searchResults.values()) {
                displayDoctor(doctor);
            }
        }
    }

    public void displaySuccessMessage(String message) {
        System.out.println("Success: " + message);
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}