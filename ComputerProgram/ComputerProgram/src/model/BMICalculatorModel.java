
package model;

public class BMICalculatorModel {
    public double calculateBMI(double weight, double height) {
        double bmi = weight / (height * height);
        return bmi;
    }

    public String getBMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard";
        } else if (bmi < 25) {
            return "Standard";
        } else if (bmi < 30) {
            return "Overweight";
        } else if (bmi < 40) {
            return "Fat - should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }
}

