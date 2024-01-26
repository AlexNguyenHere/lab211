
package model;

public class ExperienceCandidate extends Candidate {
    private int expInYears;
    private String proSkill;

    public ExperienceCandidate(String firstName, String lastName, String birthDate, String address, String phone, String email, int expInYears, String proSkill) {
        super(firstName, lastName, birthDate, address, phone, email, 0);
        this.expInYears = expInYears;
        this.proSkill = proSkill;
    }

    public int getExpInYears() {
        return expInYears;
    }

    public String getProSkill() {
        return proSkill;
    }
}
