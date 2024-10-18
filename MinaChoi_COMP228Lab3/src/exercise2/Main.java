package exercise2;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Enter the name of the game tester:");

        String type = JOptionPane.showInputDialog(null, "Is the game tester full-time or part-time? (Enter 'full' for full-time or 'part' for part-time):");

        GameTester tester = null;

        if (type.equalsIgnoreCase("full")) {
            tester = new FullTimeGameTester(name);
        } else if (type.equalsIgnoreCase("part")) {
            String hoursInput = JOptionPane.showInputDialog(null, "Enter the number of hours worked for the part-time tester:");
            int hours;
            try {
                hours = Integer.parseInt(hoursInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for hours. Exiting program.");
                System.exit(0);
                return;
            }
            tester = new PartTimeGameTester(name, hours);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter 'full' or 'part'. Exiting program.");
            System.exit(0);
        }

        String message = "Game Tester: " + tester.getName() +
                "\nFull-Time: " + tester.isFullTime() +
                "\nSalary: $" + tester.determineSalary();

        JOptionPane.showMessageDialog(null, message);
    }
}
