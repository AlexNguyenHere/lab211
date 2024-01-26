
package validation;
import view.CandidateManagementView;
public class Validation {
    public String validateBirthDate(String birthDate) {
    int currentYear = java.time.Year.now().getValue();
    if (birthDate.length() != 4) {
      return null;
    } else {
      try {
        int year = Integer.parseInt(birthDate);
        if (year < 1900 || year > currentYear) {
          return "Invalid birth date. Please enter a year between 1900 and " + currentYear + ".";
        } else {
          return birthDate;
        }
      } catch (NumberFormatException e) {
        return null;
      }
    }
}

    public String validatePhone(String phone) {
        if (phone.length() > 10) {
            System.out.println("Invalid phone number. Please enter at least 10 digits.");
            return null;
        } else {
            return validatePhone(phone);
        }
    }

    public String validateEmail(String email) {
        if (!email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {
            System.out.println("Invalid email address. Please enter a valid email address.");
            return null;
        } else {
            return email;
        }
    }

    public String validateGraduationRank(String graduationRank) {
        if (!graduationRank.equals("Excellence") && !graduationRank.equals("Good") && !graduationRank.equals("Fair") && !graduationRank.equals("Poor")) {
            System.out.println("Invalid graduation rank. Please enter 'Excellence', 'Good', 'Fair', or 'Poor'.");
            return null;
        } else {
            return graduationRank;
        }
    }

    public int validateExperience(String experience) {
    try {
        int exp = Integer.parseInt(experience);
        if (exp < 0) {
            System.out.println("Invalid experience. Please enter a non-negative number.");
            return -1;
        } else {
            return exp;
        }
    } catch (NumberFormatException e) {
        System.out.println("Invalid experience. Please enter a valid number.");
        return -1;
    }
}
}