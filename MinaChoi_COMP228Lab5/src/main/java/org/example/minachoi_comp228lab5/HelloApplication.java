package org.example.minachoi_comp228lab5;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        primaryStage.setScene(new Scene(loader.load(), 800, 600));
        primaryStage.setTitle("Lab 5 Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}