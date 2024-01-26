
package view;

import java.util.List;
import java.util.Scanner;
import model.Candidate; 

public class CandidateManagementView {
    private Scanner scanner;

    public CandidateManagementView() {
        scanner = new Scanner(System.in);
    }

    public int displayMainMenu() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Create Experience Candidate");
        System.out.println("2. Create Fresher Candidate");
        System.out.println("3. Create Intern Candidate");
        System.out.println("4. Search Candidates");
        System.out.println("5. Display Candidates");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
        return scanner.nextInt();
    }

    public String getInput(String message) {
        System.out.print(message + ":");
        return scanner.nextLine();
    }

    public int getIntInput(String message) {
        System.out.print(message + "");
        return scanner.nextInt();
    }

    public void displayCandidates(List<Candidate> candidates) {
    System.out.println("List of candidates:");
    System.out.println("===========EXPERIENCE CANDIDATE============");
    for (Candidate candidate : candidates) {
        if (candidate.getCandidateType() == 0) {
            String fullName = candidate.getFirstName() + " " + candidate.getLastName();
            System.out.println(fullName);
        }
    }
    
    System.out.println("==========FRESHER CANDIDATE==============");
    for (Candidate candidate : candidates) {
        if (candidate.getCandidateType() == 1) {
            String fullName = candidate.getFirstName() + " " + candidate.getLastName();
            System.out.println(fullName);
        }
    }
    
    System.out.println("===========INTERN CANDIDATE==============");
    for (Candidate candidate : candidates) {
        if (candidate.getCandidateType() == 2) {
            String fullName = candidate.getFirstName() + " " + candidate.getLastName();
            System.out.println(fullName);
        }
    }
}
    public void displayCandidateDetails(List<Candidate> candidates) {
    System.out.println("Candidates found:");
    for (Candidate candidate : candidates) {
        String fullName = candidate.getFirstName() + " " + candidate.getLastName();
        String birthDate = candidate.getBirthDate();
        String address = candidate.getAddress();
        String phone = candidate.getPhone();
        String email = candidate.getEmail();
        int candidateType = candidate.getCandidateType();

        System.out.println(fullName + " | " + birthDate + " | " + address + " | " + phone + " | " + email + " | " + candidateType);
    }
}
}
