package exercise1;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Insurance[] insuranceArray = new Insurance[100];
        int i = 0;

        while (true) {
            String insuranceType = JOptionPane.showInputDialog(null, "Enter the type of insurance (Life or Health):");

            if (!insuranceType.equalsIgnoreCase("Life") && !insuranceType.equalsIgnoreCase("Health")) {
                JOptionPane.showMessageDialog(null, "Invalid insurance type. Please enter only 'Life' or 'Health'. Exiting program.");
                break;
            }

            String costInput = JOptionPane.showInputDialog(null, "Enter the monthly cost for " + insuranceType + " insurance:");

            if (costInput == null || costInput.trim().isEmpty()) {
                break;
            }

            double cost;
            try {
                cost = Double.parseDouble(costInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid cost entered. Please enter a valid number.");
                continue;
            }

            Insurance insurance = null;
            if (insuranceType.equalsIgnoreCase("Life")) {
                insurance = new Life();
            } else if (insuranceType.equalsIgnoreCase("Health")) {
                insurance = new Health();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid insurance type. Please enter 'Life' or 'Health'.");
                continue;
            }

            insurance.setInsuranceCost(cost);
            insuranceArray[i] = insurance;
            i++;
        }

        for (Insurance insurance : insuranceArray) {
            if (insurance != null) {
                insurance.displayInfo();
            }
        }
    }
}
