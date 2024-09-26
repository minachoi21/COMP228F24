package exercise2;

import javax.swing.*;
import java.util.Random;

public class Lotto {
    private final int[] numbers = new int[3];

    public Lotto() {
        populateNumbers();
    }

    public void populateNumbers() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(9) + 1;
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getSum() {
        return numbers[0] + numbers[1] + numbers[2];
    }

    public void startLotto() {
        // get user number
        String input = JOptionPane.showInputDialog(null, "Choose a number between 3 and 27:");
        int userNumber;
        try {
            userNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        if (userNumber < 3 || userNumber > 27) {
            JOptionPane.showMessageDialog(null, "Invalid number. Please choose a number between 3 and 27.");
            System.exit(0);
        }

        boolean isLose = true;

        // start rolls
        for (int i = 1; i <= 5; i++) {
            // populate new numbers
            populateNumbers();
            int sum = getSum();
            isLose = sum != userNumber;

            // show a rolling dialog
            String message = String.format("We are rolling.. \nYour number:%d\nSum is:%d\nWin: %s", userNumber, sum,isLose ? "No" : "Yes");
            JOptionPane.showMessageDialog(null,  message, "Roll: " + i,
                    JOptionPane.INFORMATION_MESSAGE);

            // if the sum and user number are identical user wins
            if (sum == userNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You win!");
                isLose = false;
                break;
            }
        }
        if(isLose) {
            JOptionPane.showMessageDialog(null, "Sorry you lose!");
        }
    }
}
