
package candidatemanagementsystem;

import controller.CandidateController;
import java.util.List;
import model.Candidate;
import view.CandidateManagementView;

public class CandidateManagementSystem {
    public static void main(String[] args) {
        CandidateController candidateController = new CandidateController();
        CandidateManagementView candidateManagementView = new CandidateManagementView();

        while (true) {
            int option = candidateManagementView.displayMainMenu();
            candidateManagementView.getInput("");

            switch (option) {
                case 1:
                    String firstName = candidateManagementView.getInput("Enter first name");
                    String lastName = candidateManagementView.getInput("Enter last name");
                    String birthDate = candidateManagementView.getInput("Enter birth date");
                    String address = candidateManagementView.getInput("Enter address");
                    String phone = candidateManagementView.getInput("Enter phone");
                    String email = candidateManagementView.getInput("Enter email");
                    int expInYears = candidateManagementView.getIntInput("Enter experience in years");
                    String proSkill = candidateManagementView.getInput("Enter professional skill");
                    candidateController.createExperienceCandidate(firstName, lastName, birthDate, address, phone, email, expInYears, proSkill);
                    break;
                case 2:
                    firstName = candidateManagementView.getInput("Enter first name");
                    lastName = candidateManagementView.getInput("Enter last name");
                    birthDate = candidateManagementView.getInput("Enter birth date");
                    address = candidateManagementView.getInput("Enter address");
                    phone = candidateManagementView.getInput("Enter phone");
                    email = candidateManagementView.getInput("Enter email");
                    String graduationDate = candidateManagementView.getInput("Enter graduation date");
                    String graduationRank = candidateManagementView.getInput("Enter graduation rank");
                    String education = candidateManagementView.getInput("Enter education");
                    candidateController.createFresherCandidate(firstName, lastName, birthDate, address, phone, email, graduationDate, graduationRank, education);
                    break;
                case 3:
                    firstName = candidateManagementView.getInput("Enter first name");
                    lastName = candidateManagementView.getInput("Enter last name");
                    birthDate = candidateManagementView.getInput("Enter birth date");
                    address = candidateManagementView.getInput("Enter address");
                    phone = candidateManagementView.getInput("Enter phone");
                    email = candidateManagementView.getInput("Enter email");
                    String majors = candidateManagementView.getInput("Enter majors");
                    String semester = candidateManagementView.getInput("Enter semester");
                    String universityName = candidateManagementView.getInput("Enter university name");
                    candidateController.createInternCandidate(firstName, lastName, birthDate, address, phone, email, majors, semester, universityName);
                    break;
                case 4:
                    String name = candidateManagementView.getInput("Enter candidate name");
                    int candidateType = candidateManagementView.getIntInput("Enter candidate type (0 for experience, 1 for fresher, 2 for intern)");
                    List<Candidate> foundCandidates = candidateController.searchCandidates(name, candidateType);
                    candidateManagementView.displayCandidateDetails(foundCandidates);
                    break;
                case 5:
                    List<Candidate> allCandidates = candidateController.getAllCandidates();
                    candidateManagementView.displayCandidates(allCandidates);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
