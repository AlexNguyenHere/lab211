
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Candidate;
import model.ExperienceCandidate;
import model.FresherCandidate;
import model.InternCandidate;

public class CandidateController {
    private List<Candidate> candidates;

    public CandidateController() {
        candidates = new ArrayList<>();
    }

    public void createExperienceCandidate(String firstName, String lastName, String birthDate, String address, String phone, String email, int expInYears, String proSkill) {
        ExperienceCandidate experienceCandidate = new ExperienceCandidate(firstName, lastName, birthDate, address, phone, email, expInYears, proSkill);
        candidates.add(experienceCandidate);
    }

    public void createFresherCandidate(String firstName, String lastName, String birthDate, String address, String phone, String email, String graduationDate, String graduationRank, String education) {
        FresherCandidate fresherCandidate = new FresherCandidate(firstName, lastName, birthDate, address, phone, email, graduationDate, graduationRank, education);
        candidates.add(fresherCandidate);
    }

    public void createInternCandidate(String firstName, String lastName, String birthDate, String address, String phone, String email, String majors, String semester, String universityName) {
        InternCandidate internCandidate = new InternCandidate(firstName, lastName, birthDate, address, phone, email, majors, semester, universityName);
        candidates.add(internCandidate);
    }

    public List<Candidate> searchCandidates(String name, int candidateType) {
        List<Candidate> foundCandidates = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if ((candidate.getFirstName().equalsIgnoreCase(name) || candidate.getLastName().equalsIgnoreCase(name)) && candidate.getCandidateType() == candidateType) {
                foundCandidates.add(candidate);
            }
        }
        return foundCandidates;
    }

    public List<Candidate> getAllCandidates() {
        return candidates;
    }
}