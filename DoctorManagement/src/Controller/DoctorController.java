package Controller;

import model.Doctor;
import view.DoctorView;
import view.MenuView;

import java.util.HashMap;
import java.util.Scanner;

public class DoctorController {
    private HashMap<String, Doctor> doctorMap;
    private DoctorView doctorView;
    private MenuView menuView;
    private Scanner scanner;

    public DoctorController() {
        doctorMap = new HashMap<>();
        doctorView = new DoctorView();
        menuView = new MenuView();
        scanner = new Scanner(System.in);
    }

    public void start() {
           System.out.println("----------Doctor Management ----------");
        while (true) {
            int choice = menuView.getMenuChoice();

            try {
                switch (choice) {
                    case 1:
                        addDoctor();
                        break;
                    case 2:
                        updateDoctor();
                        break;
                    case 3:
                        deleteDoctor();
                        break;
                    case 4:
                        searchDoctor();
                        break;
                    case 5:
                        System.out.println("Exiting the program...");
                        System.exit(0);
                    default:
                        menuView.displayErrorMessage("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                menuView.displayErrorMessage(e.getMessage());
            }

            System.out.println();
        }
    }

  private void addDoctor() throws Exception {
    System.out.println("----------Add Doctor ----------");
    System.out.println("Enter doctor details:");

    String code;
    do {
        System.out.print("Code: ");
        code = scanner.nextLine();
        if (code.isEmpty()) {
            System.out.println("Code cannot be null or empty. Please try again.");
        }
    } while (code.isEmpty());

    System.out.print("Name: ");
    String name = scanner.nextLine();
    System.out.print("Specialization: ");
    String specialization = scanner.nextLine();
    System.out.print("Availability: ");
    int availability = scanner.nextInt();
    scanner.nextLine();

    Doctor doctor = new Doctor(code, name, specialization, availability);
    if (!doctorMap.containsKey(code)) {
        doctorMap.put(code, doctor);
        doctorView.displaySuccessMessage("Doctor added successfully.");
    } else {
        throw new Exception("Doctor with the same code already exists.");
    }
}

    private void updateDoctor() throws Exception {
        System.out.println("----------Update Doctor ----------");
        System.out.print("Enter doctor code: ");
        String code = scanner.nextLine();

        if (!doctorMap.containsKey(code)) {
            throw new Exception("Doctor not found.");
        }

        Doctor doctor = doctorMap.get(code);

        System.out.println("Enter new details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Availability: ");
        int availability = scanner.nextInt();
        scanner.nextLine();

        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);

        doctorView.displaySuccessMessage("Doctor updated successfully.");
    }

    private void deleteDoctor() throws Exception {
        System.out.println("----------Delete Doctor ----------");
        System.out.print("Enter doctor code: ");
        String code = scanner.nextLine();

        if (!doctorMap.containsKey(code)) {
            throw new Exception("Doctor not found.");
        }

        doctorMap.remove(code);
        doctorView.displaySuccessMessage("Doctor deleted successfully.");
    }

    private void searchDoctor() {
        System.out.println("----------Search Doctor ----------");
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();

        HashMap<String, Doctor> searchResults = new HashMap<>();
        for (Doctor doctor : doctorMap.values()) {
            if (doctor.getCode().contains(keyword) || doctor.getName().contains(keyword) || doctor.getSpecialization().contains(keyword)) {
                searchResults.put(doctor.getCode(), doctor);
            }
        }

        doctorView.displaySearchResults(searchResults);
    }
}