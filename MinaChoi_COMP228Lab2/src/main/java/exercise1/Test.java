package exercise1;

import javax.swing.*;
import java.util.Random;

public class Test {
    String[] questions = {
            "What is Java?",
            "What is an object in Java?",
            "What is inheritance?",
            "What is polymorphism?",
            "What is encapsulation?"
    };

    String[][] options = {
            {"1. Programming language", "2. Coffee", "3. Animal", "4. None"},
            {"1. Instance of a class", "2. Variable", "3. Data type", "4. None"},
            {"1. Acquiring properties", "2. Overloading", "3. Overriding", "4. None"},
            {"1. Many forms", "2. Encapsulation", "3. Abstraction", "4. None"},
            {"1. Binding data", "2. Encapsulation", "3. Polymorphism", "4. None"}
    };

    private final int[] answers = {
            0,0,0,0,0
    };

    private int correctCount = 0;

    public boolean checkAnswer(int questionIndex, int answerIndex) {
        return answerIndex == answers[questionIndex];
    }

    public String generateMessage(boolean isCorrect) {
        Random random = new Random();
        return switch (random.nextInt(4)) {
            case 0 -> isCorrect ? "Excellent!" : "No. Please try again.";
            case 1 -> isCorrect ? "Good!" : "Wrong. Try once more.";
            case 2 -> isCorrect ? "Keep up the good work!" : "Don't give up!";
            default -> isCorrect ? "Nice work!" : "No. Keep trying.";
        };
    }

    public int simulateQuestion(int questionIndex) {
        String question = questions[questionIndex];
        // show the dialog of the question and the answer
        return JOptionPane.showOptionDialog(
                null,
                question,
                "Question",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options[questionIndex],
                null
        );
    }

    public void inputAnswer() {
        for(int i =0; i< questions.length; i++) {
            // get the answer from user
            int answerIndex = simulateQuestion(i);

            // check if it's right or wrong
            boolean isCorrect = checkAnswer(i, answerIndex);

            // generate a random congratulatory message
            String message = generateMessage(isCorrect);
            JOptionPane.showMessageDialog(null,  message, isCorrect? "Correct" : "Incorrect",
                    JOptionPane.INFORMATION_MESSAGE);
            if(isCorrect) {
                correctCount++;
            }
        }

        // question ends and show an end dialog
        int incorrectCount = questions.length - correctCount;
        String message = String.format("Correct: %d, Incorrect: %d, Percentage: %s%%", correctCount, incorrectCount, (correctCount * 100.0 / questions.length));
        JOptionPane.showMessageDialog(null,  message, "END",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
