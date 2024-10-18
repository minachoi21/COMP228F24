package exercise3;

import javax.swing.*;

public class ProcessMortgage {
    public static void main(String[] args) {
        Mortgage[] mortgages = new Mortgage[3];

        String primeRateInput = JOptionPane.showInputDialog("Enter the current prime interest rate:");
        double primeRate = Double.parseDouble(primeRateInput);

        for (int i = 0; i < mortgages.length; i++) {
            String typeInput = JOptionPane.showInputDialog("Enter mortgage type (1 for Business, 2 for Personal):");
            int type = Integer.parseInt(typeInput);
            String mortgageNumber = JOptionPane.showInputDialog("Enter mortgage number:");
            String customerName = JOptionPane.showInputDialog("Enter customer name:");
            String amountInput = JOptionPane.showInputDialog("Enter mortgage amount:");
            double amount = Double.parseDouble(amountInput);
            String termInput = JOptionPane.showInputDialog("Enter mortgage term (1 for short, 3 for medium, 5 for long):");
            int term = Integer.parseInt(termInput);

            if (type == 1) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, amount, primeRate, term);
            } else {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, primeRate, term);
            }
        }

        StringBuilder result = new StringBuilder("Mortgage Details:\n");
        for (Mortgage mortgage : mortgages) {
            result.append(mortgage.getMortgageInfo()).append("\n");
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }
}
