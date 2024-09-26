package exercise1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            // This is to ensure a consistent UI between macOS and Windows
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Test test = new Test();
        test.inputAnswer();
    }
}