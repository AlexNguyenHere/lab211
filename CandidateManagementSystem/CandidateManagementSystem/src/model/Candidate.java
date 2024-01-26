
package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Candidate {
    private static int nextCandidateId = 1;
    private int candidateId;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String address;
    private String phone;
    public String email;
    private int candidateType;

    public Candidate(String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType) {
        this.candidateId = nextCandidateId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getCandidateType() {
        return candidateType;
    }
}
